import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Optimalizovaná (single-thread) brute-force simulace pro EDU účely.
 * Pouze pro testování vlastních hesel / bezpečnostní benchmark.
 *
 * NEPOUŽÍVAT k prolomení cizích účtů.
 */
public class BruteForceOptimized {

    static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String DIGITS = "0123456789";
    static final String SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    // --- Konfigurace ---
    static String target = "1000000";    // hledané heslo (změň jen pro své testy)
    static int maxLen = 7;
    static boolean useLower = false;
    static boolean useUpper = false;
    static boolean useDigits = true;
    static boolean useSymbols = false;

    // Statistiky
    static volatile long attempts = 0L;

    public static void main(String[] args) {
        // Jednoduché CLI (volitelné)
        if (args.length >= 1) target = args[0];
        if (args.length >= 2) {
            try { maxLen = Integer.parseInt(args[1]); } catch (Exception ignored) {}
        }
        if (args.length >= 3) {
            String opts = args[2].toLowerCase(Locale.ROOT);
            useLower = opts.contains("l");
            useUpper = opts.contains("u");
            useDigits = opts.contains("d");
            useSymbols = opts.contains("s");
        }

        String charset = buildCharset();
        if (charset.isEmpty()) {
            System.err.println("Žádné znaky zvoleny. Použij l/u/d/s v options.");
            return;
        }

        System.out.println("Hledané heslo: " + target);
        System.out.println("Charset size: " + charset.length());
        System.out.println("Max délka: " + maxLen);

        // Předpočítat target jako char[]
        char[] targetChars = target.toCharArray();

        long startTime = System.nanoTime();
        boolean found = false;

        // Buffer pro generovanou kombinaci (maxLen)
        char[] buffer = new char[maxLen];

        for (int len = 1; len <= maxLen && !found; len++) {
            // Pokud hledané heslo má jinou délku, můžeme ho přeskočit (ale to už dělá porovnání)
            if (targetChars.length != len && targetChars.length <= maxLen) {
                // Pokračujeme, protože nechceme předpokládat
            }

            found = searchLengthIterative(charset, buffer, len, targetChars);
        }

        long elapsedNanos = System.nanoTime() - startTime;
        long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(elapsedNanos);
        System.out.println("Konec. Nalezeno: " + found);
        System.out.println("Pokusů: " + attempts);
        System.out.println("Čas (ms): " + elapsedMillis);
        double s = elapsedNanos / 1_000_000_000.0;
        System.out.printf("Rychlost: %.2f pokusů/s%n", attempts / s);
    }

    static String buildCharset() {
        StringBuilder sb = new StringBuilder();
        if (useLower) sb.append(LOWER);
        if (useUpper) sb.append(UPPER);
        if (useDigits) sb.append(DIGITS);
        if (useSymbols) sb.append(SYMBOLS);
        return sb.toString();
    }

    /**
     * Iterativní generování všech kombinací délky 'len' bez alokací Stringů.
     * Vrací true pokud byla kombinace nalezena (target).
     */
    static boolean searchLengthIterative(String charset, char[] buffer, int len, char[] target) {
        int radix = charset.length();
        int[] idx = new int[len];        // indexy do charsetu
        Arrays.fill(idx, 0);

        // Pokud target má jinou délku než aktuální len, porovnáme jen když délky souhlasí
        boolean targetLengthMatches = (target.length == len);

        // Celkový počet kombinací (může být velké číslo)
        // Pozor: pokud by to přeteklo long, museli bychom to ošetřit, ale pro běžné délky to OK.
        long total = 1;
        for (int i = 0; i < len; i++) total *= radix;

        long localCount = 0;
        long lastReport = System.nanoTime();

        for (long iter = 0; iter < total; iter++) {
            // naplnit buffer podle idx (rychlé)
            for (int j = 0; j < len; j++) buffer[j] = charset.charAt(idx[j]);

            attempts++;
            localCount++;

            // report každou sekundu (nebo každých 1_000_000 pokusů)
            long now = System.nanoTime();
            if (now - lastReport >= 1_000_000_000L) {
                double s = (now - lastReport) / 1_000_000_000.0;
                System.out.printf("Progress: celkem %d pokusů (poslední sekunda ~ %.2f pokusů/s)%n",
                        attempts, localCount / s);
                localCount = 0;
                lastReport = now;
            }

            // Pokud délka souhlasí, porovnáme char po char — bez vytváření Stringu
            if (targetLengthMatches) {
                if (equalsCharArray(buffer, target, len)) {
                    System.out.println("Nalezeno: " + new String(buffer, 0, len));
                    return true;
                }
            }

            // inkrementace idx (přičtení 1 v základu radix)
            for (int pos = len - 1; pos >= 0; pos--) {
                if (++idx[pos] < radix) {
                    break;
                } else {
                    idx[pos] = 0;
                }
            }
        }
        return false;
    }

    static boolean equalsCharArray(char[] buffer, char[] target, int len) {
        // Porovná jen prvních len znaků
        if (target.length < len) return false;
        for (int i = 0; i < len; i++) {
            if (buffer[i] != target[i]) return false;
        }
        return true;
    }
}
