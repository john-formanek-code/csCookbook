package listopad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Pom {

    // Pomocná třída pro statistiky
    static class Stats {
        long comparisons = 0;
        long swaps = 0;
    }

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length != 1) {
            System.err.println("Chyba: Musí být zadán vstupní soubor.");
            return;
        }

        String fileName = args[0];
        Scanner sc = new Scanner(new File(fileName));

        System.out.println(fileName);

        int run = 1;

        while (sc.hasNextInt()) {

            int size = sc.nextInt();      // počet prvků
            int[] data = new int[size];

            // načtení dat
            for (int i = 0; i < size; i++) {
                if (!sc.hasNextInt()) {
                    System.err.println("Chyba: Nedostatek dat.");
                    return;
                }
                data[i] = sc.nextInt();
            }

            // Kopie pro různé algoritmy
            int[] a1 = Arrays.copyOf(data, size);
            int[] a2 = Arrays.copyOf(data, size);
            int[] a3 = Arrays.copyOf(data, size);

            Stats st = new Stats();

            // BubbleSort
            bubbleSort(a1, st);
            print(run, "BubbleSort", a1, st);

            // InsertSort
            st.comparisons = 0;
            st.swaps = 0;
            insertSort(a2, st);
            print(run, "InsertSort", a2, st);

            // QuickSort
            st.comparisons = 0;
            st.swaps = 0;
            quickSort(a3, 0, size - 1, st);
            print(run, "QuickSort", a3, st);

            run++;
        }

        sc.close();
    }

    // ------------------------ Výpis ------------------------

    static void print(int run, String method, int[] data, Stats st) {
        System.out.println(
                "RUN " + run + " - " + method +
                " : COMPARASIONS " + st.comparisons +
                " -> SWAPS " + st.swaps
        );

        System.out.print("->  ");
        for (int x : data) System.out.print(x + " ");
        System.out.println("\n");
    }


    // ------------------------ Bubble Sort ------------------------

    /**
     * Bubble sort: opakované porovnávání sousedních prvků a jejich výměna.
     * Složitost: O(n^2) – dvě vnořené smyčky, porovnáváme každý s každým.
     */
    static void bubbleSort(int[] arr, Stats st) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {

                st.comparisons++;

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1, st);
                }
            }
        }
    }


    // ------------------------ Insert Sort ------------------------

    /**
     * Insert sort: prvek se postupně vkládá do již seřazené části pole vlevo.
     * Složitost: O(n^2) – v nejhorším se každý prvek posouvá přes celé pole.
     */
    static void insertSort(int[] arr, Stats st) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            st.swaps++;

            int j = i - 1;

            while (j >= 0) {
                st.comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    st.swaps++;
                    j--;
                } else break;
            }

            arr[j + 1] = key;
            st.swaps++;
        }
    }


    // ------------------------ Quick Sort ------------------------

    /**
     * Quick sort: rozdělí pole podle pivotu a rekurzivně třídí části.
     * Složitost: průměr O(n log n), nejhorší O(n^2) – pokud je špatně zvolen pivot.
     */
    static void quickSort(int[] arr, int left, int right, Stats st) {
        int i = left;
        int j = right;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                st.comparisons++;
                i++;
            }
            st.comparisons++;

            while (arr[j] > pivot) {
                st.comparisons++;
                j--;
            }
            st.comparisons++;

            if (i <= j) {
                swap(arr, i, j, st);
                i++;
                j--;
            }
        }

        if (left < j) quickSort(arr, left, j, st);
        if (i < right) quickSort(arr, i, right, st);
    }


    // ------------------------ Swap ------------------------

    static void swap(int[] arr, int a, int b, Stats st) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        st.swaps++;
    }
}
