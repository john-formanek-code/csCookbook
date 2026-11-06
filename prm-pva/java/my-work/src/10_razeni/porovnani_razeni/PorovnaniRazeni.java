package listopad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test_alg {

    // Globální proměné pro počítání porovnání a prohození
    static long comparisons = 0;
    static long swaps = 0;

    /////////////////////////////////// insertSort
    // Prvek se postupně vkládá do již seřazené části pole vlevo.
    // funguje to jako třídění karet v ruce, postupně procházíme prvky v poli a dáváme je na správné místo
    /*
     * Porovnávání - 1/2 (n*n -n)
     * 
     * Přesuny - 1/2 (n*n + n -2)
     * 
     * Složitost - O(n^2) – v nejhorším se každý prvek posouvá přes celé pole.
     */

    public static int[] insertSort(int[] data) {
        comparisons = 0;
        swaps = 0;

        for (int i = 1; i < data.length; i++) { // zaciname od 1 protože prvni prvek v poli bereme jako serazeny
            int key = data[i];
            int j = i - 1;
            swaps++;

            while ((j >= 0) && (data[j] > key)) {
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

    public static int callSelf(int count) {
        System.out.println("IN count: " + count);
        callSelf(++count);
        System.out.println("OUT count: " + count);
        return 1;

    }
    //////////////////////////////////////////

    ////////////// bubbleSort
    // 1/2 * (n*n-n)
    // Porovnává dva sousední prvky a pokud nejsou správně seřazené tak je prohodí. A takto pokračujeme přes celé pole.
    // Složitost: O(n^2) – dvě vnořené smyčky, porovnáváme každý s každým.
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
    ///////////////////////////////////////////////

    ////////////// quickSort
    // O(n * log n)
    // Velmi dobrý algoritmus, rozděluje pole pomocí pivotů, pole poté dělí na
    // poloviny proto logaritmická složitost.
    // Účinost tohoto algortimu záleží na zvolení správného pivotu, pokud pivot
    // zvolíme jako nejmenší nebo největší prvek tak je to nejhorší
    // možný případ... O(n*n) 
    //to je ale malá pravděpodobnost ve velkém poli. Teoreticky se dá použít median.
    public static void quickSort(int[] data, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex)
            return;

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

        if (leftIndex < j)
            quickSort(data, leftIndex, j);
        if (i < rightIndex)
            quickSort(data, i, rightIndex);
    }
    ///////////////////////////////////////

    public static void main(String[] args) throws FileNotFoundException {
        
        File vstup = new File("pokusy/src/listopad/data.txt");
        Scanner sc = new Scanner(vstup);
        if (!vstup.exists()) {
            System.err.println("Soubor neexistuje.");
            return;
        }

        if (!vstup.canRead()) {
            System.err.println("Soubor nelze číst.");
            return;
        }

        System.out.println(vstup.getName()); // výpis názvu souboru

        

        int run = 1;

        while (sc.hasNextInt()) {

            int size = sc.nextInt(); // načtení počtu prvků
            int[] data = new int[size];

            for (int i = 0; i < size; i++) {
                if (!sc.hasNextInt()) {
                    System.err.println("Nedostatek dat v souboru.");
                    return;
                }
                data[i] = sc.nextInt();
            }

            //BUBBLE SORT
            int[] b = data.clone();
            bubbleSort(b);
            System.out.println("RUN " + run + " - BubbleSort : COMPARASIONS " + comparisons + " -> SWAPS " + swaps);
            printArray(b);

            //INSERT SORT
            int[] i = data.clone();
            insertSort(i);
            System.out.println("RUN " + run + " - InsertSort : COMPARASIONS " + comparisons + " -> SWAPS " + swaps);
            printArray(i);

            //QUICK SORT
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
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
    
}
