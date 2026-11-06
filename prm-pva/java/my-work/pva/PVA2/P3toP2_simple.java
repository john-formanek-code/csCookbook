import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class P3toP2_simple {

    private static void bad() {
        System.out.println("špatný standart");
        System.exit(0);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Použití: java P3toP2_simple <vstup_P3.ppm> <vystup_P2.pgm>");
            return;
        }

        try (Scanner sc = new Scanner(new FileInputStream(args[0]), StandardCharsets.US_ASCII);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.US_ASCII))) {

            sc.useDelimiter("\\s+"); // libovolné whitespace

            // --- HLAVIČKA ---
            if (!sc.hasNext()) bad();
            String magic = sc.next();
            if (!"P3".equals(magic)) bad();

            if (!sc.hasNextInt()) bad(); int width  = sc.nextInt();
            if (!sc.hasNextInt()) bad(); int height = sc.nextInt();
            if (!sc.hasNextInt()) bad(); int maxVal = sc.nextInt();
            if (width <= 0 || height <= 0 || maxVal <= 0) bad();

            // --- ZÁPIS HLAVIČKY P2 (MAX_VAL zachován) ---
            out.write("P2\n");
            out.write(width + " " + height + "\n");
            out.write(Integer.toString(maxVal));
            out.write('\n');

            // data 
            int total = width * height;
            for (int p = 0; p < total; p++) {
                if (!sc.hasNextInt()) bad(); int r = sc.nextInt();
                if (!sc.hasNextInt()) bad(); int g = sc.nextInt();
                if (!sc.hasNextInt()) bad(); int b = sc.nextInt();
                if (r < 0 || r > maxVal || g < 0 || g > maxVal || b < 0 || b > maxVal) bad();

                int gray = (int)Math.round(0.299 * r + 0.587 * g + 0.114 * b);
                if (gray < 0) gray = 0; if (gray > maxVal) gray = maxVal;

                int x = p % width;
                if (x > 0) out.write(' ');
                out.write(Integer.toString(gray));
                if (x == width - 1) out.write('\n');
            }
            out.flush();

            // žádná další data nesmí zůstat
            if (sc.hasNext()) bad(); // cokoliv krom whitespace navíc = špatně

        } catch (Exception e) {
            bad(); // zachyceni jakékoliv I/O nebo formátová chyba = "špatný standart"
        }
    }
}
