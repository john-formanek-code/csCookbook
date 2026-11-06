package rijen.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {

        // Nastavení cesty k souboru
        File vstup = new File("pokusy/src/rijen/test/test.txt");

        // Kontrola, jestli soubor existuje
        if (!vstup.exists()) {
            System.err.println("Chyba: Soubor '" + vstup.getPath() + "' neexistuje!");
            return;
        }

        // Kontrola, jestli se dá číst
        if (!vstup.canRead()) {
            System.err.println("Chyba: Soubor '" + vstup.getPath() + "' nelze číst!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        Scanner ctecka = new Scanner(vstup);

        // Výpis názvu souboru
        System.out.println(vstup.getName());

        int runCount = 0;

        while (ctecka.hasNextInt()) {
            int velikost = ctecka.nextInt(); // velikost pole
            if (!ctecka.hasNextInt()) {
                System.err.println("Chyba: Očekáváno hledané číslo po velikosti pole!");
                break;
            }

            int searchedNumber = ctecka.nextInt();

            // načti data pole
            int[] data = new int[velikost];
            boolean dostatekDat = true;
            for (int i = 0; i < velikost; i++) {
                if (ctecka.hasNextInt()) {
                    data[i] = ctecka.nextInt();
                } else {
                    System.err.println("Chyba: Nedostatek dat v souboru, očekáváno " + velikost + " čísel!");
                    dostatekDat = false;
                    break;
                }
            }
            if (!dostatekDat)
                break;

            runCount++;

            // zjisti, jestli je pole seřazené
            boolean sorted = isSorted(data);
            boolean found;
            String method;

            if (sorted) {
                found = binarySearch(data, searchedNumber);
                method = "Binary";
            } else {
                found = linearSearch(data, searchedNumber);
                method = "Bruteforce";
            }

            // výpis výsledku
            System.out.printf("RUN %d - %s : %d -> %s%n",
                    runCount, method, searchedNumber, found ? "true" : "false");
        }

        // Zavřeme čtečku
        ctecka.close();
        sc.close();
    }

    /**
     * Určí, zda je pole vzestupně seřazené.
     */
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Binární vyhledávání (bisekce).
     * Časová složitost: O(log n)
     * Prostorová složitost: O(1)
     */
    public static boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target)
                return true;
            else if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    /**
     * Lineární (bruteforce) vyhledávání.
     * Časová složitost: O(n)
     * Prostorová složitost: O(1)
     */
    public static boolean linearSearch(int[] array, int target) {
        for (int value : array) {
            if (value == target)
                return true;
        }
        return false;
    }
}
