package rijen.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test_Horacek {

    public static void main(String[] args) throws FileNotFoundException {
        File vstup = new File("pokusy/src/rijen/test/test.txt");

        // Základní kontroly souboru
        if (!vstup.exists()) {
            System.err.println("Chyba: Soubor neexistuje: " + vstup.getPath());
            return;
        }
        if (!vstup.canRead()) {
            System.err.println("Chyba: Soubor nelze číst: " + vstup.getPath());
            return;
        }

        // Vypíše název souboru
        System.out.println(vstup.getName());

        Scanner ctecka = new Scanner(vstup);
        int runCount = 0;

        // Čteme dokola dva řádky
        // Hledaná čísla jsou vždy na lichých řádkách jako druhé číslo, a to je taky hledane. Takhle se to vždy opakuje.
        while (ctecka.hasNextInt()) {
            int velikost = ctecka.nextInt();

            if (!ctecka.hasNextInt()) {
                System.err.println("Chyba: Očekáváno hledané číslo po velikosti pole.");
                break;
            }
            int hledane = ctecka.nextInt();

            // Načte pole
            int[] pole = new int[velikost];
            boolean ok = true;
            for (int i = 0; i < velikost; i++) {
                if (ctecka.hasNextInt()) {
                    pole[i] = ctecka.nextInt();
                } else {
                    System.err.println("Chyba: Nedostatek dat, očekáváno " + velikost + " čísel.");
                    ok = false;
                    break;
                }
            }
            if (!ok)
                break;

            runCount++;

            // Zjistí, jestli je pole seřazené vzestupně
            boolean serazene = isSorted(pole);

            boolean nalezeno;
            String metoda;
            if (serazene) {
                nalezeno = binarySearch(pole, hledane);
                metoda = "Binary";
            } else {
                nalezeno = linearSearch(pole, hledane);
                metoda = "Bruteforce";
            }

            // Výsledek
            System.out.printf("RUN %d - %s : %d -> %s%n",
                    runCount, metoda, hledane, nalezeno ? "true" : "false");
        }

        ctecka.close();
    }

    // Kontrola, zda je pole vzestupně seřazené
    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1])
                return false;
        }
        return true;
    }

    // Binární vyhledávání (pole musí být seřazené)
    // Časová složitost je O(log) protože pole se dělí na poloviny
    // Prostorová složitost je O(n) potřebujeme všechny prvky 
    public static boolean binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (a[middle] == target)
                return true;
            if (a[middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return false;
    }

    // Lineární vyhledávání
    // Časová složitost je O(n) - kv nejhorším případě se projde každý prvek v poli, takže čas zavisí na počtu prvků
    // Prostorová složitost je O(n) potřebujeme všechny prvky 
    public static boolean linearSearch(int[] a, int target) {
        for (int v : a)
            if (v == target)
                return true;
        return false;
    }
}
