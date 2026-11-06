package listopad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pom2 {

    // Globální počítadla
    static long comparisons = 0;
    static long swaps = 0;

    /////////////////////////////////// INSERT SORT
    public static int[] insertSort(int[] data) {
        comparisons = 0;
        swaps = 0;

        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            swaps++;

            int j = i - 1;

            while (j >= 0 && data[j] > key) {
                comparisons++;
                data[j + 1] = data[j];
                swaps++;
                j--;
            }

            comparisons++;
            data[j + 1] = key;
            swaps++;
        }
        return data;
    }

    ////////////////////////////////////////// BUBBLE SORT
    static int[] bubbleSort(int[] data) {
        comparisons = 0;
        swaps = 0;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {

                comparisons++;

                if (data[j] > data[j + 1]) {
                    int tem = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tem;
                    swaps++;
                }
            }
        }
        return data;
    }

    /////////////////////////////////////////////// QUICK SORT
    public static void quickSort(int[] data, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;

        int i = leftIndex;
        int j = rightIndex;
        int pivot = data[(leftIndex + rightIndex) / 2];

        while (i <= j) {

            while (data[i] < pivot) {
                comparisons++;
                i++;
            }
            comparisons++;

            while (data[j] > pivot) {
                comparisons++;
                j--;
            }
            comparisons++;

            if (i <= j) {
                int pom = data[i];
                data[i] = data[j];
                data[j] = pom;
                swaps++;
                i++;
                j--;
            }
        }

        if (leftIndex < j) quickSort(data, leftIndex, j);
        if (i < rightIndex) quickSort(data, i, rightIndex);
    }

    ////////////////////////////////////////////////////// MAIN
    public static void main(String[] args) throws FileNotFoundException {

        File vstup = new File("pokusy/src/listopad/data.txt");

        if (!vstup.exists()) {
            System.err.println("Soubor neexistuje.");
            return;
        }

        if (!vstup.canRead()) {
            System.err.println("Soubor nelze číst.");
            return;
        }

        System.out.println(vstup.getName()); // výpis názvu souboru

        Scanner sc = new Scanner(vstup);

        int run = 1;

        while (sc.hasNextInt()) {

            int size = sc.nextInt();      // načtení počtu prvků
            int[] data = new int[size];

            for (int i = 0; i < size; i++) {
                if (!sc.hasNextInt()) {
                    System.err.println("Nedostatek dat v souboru.");
                    return;
                }
                data[i] = sc.nextInt();
            }

            // ------------ BUBBLE SORT ------------
            int[] b = data.clone();
            bubbleSort(b);
            System.out.println("RUN " + run + " - BubbleSort : COMPARASIONS " + comparisons + " -> SWAPS " + swaps);
            printArray(b);

            // ------------ INSERT SORT ------------
            int[] i = data.clone();
            insertSort(i);
            System.out.println("RUN " + run + " - InsertSort : COMPARASIONS " + comparisons + " -> SWAPS " + swaps);
            printArray(i);

            // ------------ QUICK SORT -------------
            int[] q = data.clone();
            comparisons = 0;
            swaps = 0;
            quickSort(q, 0, q.length - 1);
            System.out.println("RUN " + run + " - QuickSort : COMPARASIONS " + comparisons + " -> SWAPS " + swaps);
            printArray(q);

            run++;
        }

        sc.close();
    }

    public static void printArray(int[] arr) {
        System.out.print("->  ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }
}
