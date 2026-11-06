import java.io.*;

public class FinalOfFinal {

    static int comparisons;
    static int swaps;
    /**
     * Dodatecna pametova slozitost : O(1) 
     *      nealokujeme dodatecnou pamet, krom par pomocnych promenych
     * Casova slozitost:
     *      prorovnani  -> O(1/2(n^2 - n))
     *      presuny     -> min O(0)
     *                  -> max O(1/2(n^2 - n))
     */
    /**
     * 
     * BUBBLE SORT - Řazení paralelou k bublině
     *
     * PRINCIP ALGORITMU:
     * Opakovaně procházíme pole a porovnáváme sousední prvky.
     * Pokud je levý prvek větší než pravý, vyměníme je.
     * V každém průchodu se největší prvek "probublá" na konec pole.
     * Opakujeme, dokud není pole seřazeno (žádná výměna v průchodu).
     *
     * Příklad: [5,2,8,1,9] → [2,5,1,8,9] → [2,1,5,8,9] → [1,2,5,8,9] ✓
     *
     * ČASOVÁ SLOŽITOST:
     *
     * Porovnání:
     *   - Nejhorší případ: O(n²) = 1/2 * (n² - n)
     *     Kdy: pole v opačném pořadí (např. [5,4,3,2,1])
     *     Příklad: n=5 → 1/2 * (25-5) = 10 porovnání
     *     Příklad: n=100 → 1/2 * (10000-100) = 4950 porovnání
     *
     *   - Nejlepší případ: O(n)
     *     Kdy: pole již seřazeno
     *     Počet: n-1 porovnání (jen jeden průchod kontroly)
     *
     *   - Průměrný případ: O(n²)
     *
     * Výměny (SWAPS):
     *   - Nejhorší případ: O(n²) = 1/2 * (n² - n)
     *   - Nejlepší případ: O(0) - žádné výměny
     *   - Průměrný případ: O(n²)
     *
     * ODVOZENÍ VZORCE:
     * Při n prvcích máme maximálně n-1 průchodů.
     * V i-tém průchodu provádíme (n-i) porovnání.
     * Celkem: (n-1) + (n-2) + ... + 1 = n*(n-1)/2 = 1/2*(n²-n)
     *
     * PROSTOROVÁ SLOŽITOST: O(1)
     * Algoritmus pracuje in-place, bez dodatečné paměti
     * (jen pomocné proměnné: temp, index, flag)
     *
     * VÝHODY:
     * - Jednoduché pochopení a implementace
     * - Stabilní řazení (zachová pořadí stejných prvků)
     *
     * NEVÝHODY:
     * - Velmi pomalé na velkých polích
     * - Horší než Insert Sort v průměru
     */

    public static int[] bubbleSort(int[] data) {
        comparisons = 0;
        swaps = 0;
        int[] arr = data.clone();

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        return arr;
    }

    /**
     * INSERT SORT - Řazení vkládáním
     *
     * PRINCIP ALGORITMU:
     * Začínáme od druhého prvku. Každý prvek vkládáme na správné místo
     * v již seřazené části pole (vlevo od aktuálního prvku).
     * Prvky, které jsou větší, posouváme doprava.
     *
     * Příklad: [5,2,8,1,9]
     *   Krok 1: Vezmi 2 → porovnej s 5 → 5>2 → posuneme 5 → [2,5,8,1,9]
     *   Krok 2: Vezmi 8 → porovnej s 5 → 5<8 → necháme → [2,5,8,1,9]
     *   Krok 3: Vezmi 1 → posuny 8,5,2 → vložíme 1 → [1,2,5,8,9]
     *   Krok 4: Vezmi 9 → 8<9 → necháme → [1,2,5,8,9] ✓
     *
     * ČASOVÁ SLOŽITOST:
     *
     * Porovnání (COMPARISONS):
     *   - Nejhorší případ: O(n²) = 1/2 * (n² - n)
     *     Kdy: pole v opačném pořadí
     *     Příklad: n=100 → ~4950 porovnání
     *
     *   - Nejlepší případ: O(n)
     *     Kdy: pole již seřazeno
     *     Počet: n-1 porovnání (bez posunů)
     *
     *   - Průměrný prípad: O(n²)
     *     Lépe než Bubble Sort v praxi díky brzkému zastavení
     *
     * Posuny (SWAPS):
     *   - Nejhorší případ: O(n²)
     *     Pozn: Posuny se počítají jako data[j+1] = data[j]
     *
     *   - Nejlepší prípad: O(0) - žádné posuny
     *     Kdy: pole seřazeno
     *
     *   - Průměrný prípad: O(n²)
     *
     * ODVOZENÍ VZORCE:
     * Pro n prvků máme n-1 kroků (od 2. prvku).
     * V i-tém kroku v nejhorším případě i porovnání.
     * Celkem: 1+2+3+...+(n-1) = n*(n-1)/2 = 1/2*(n²-n)
     *
     * Příklad n=5: 1+2+3+4 = 10 porovnání
     * Příklad n=100: suma 1..99 = 4950 porovnání
     *
     * PROSTOROVÁ SLOŽITOST: O(1)
     * Algoritmus pracuje in-place bez dodatečné paměti
     *
     * VÝHODY:
     * - Jednoduché pochopení
     * - VELMI EFEKTIVNÍ pro skoro seřazená pole (blízko O(n))
     * - Stabilní řazení
     * - Lepší než Bubble Sort v průměru
     *
     * NEVÝHODY:
     * - Stále O(n²) v nejhorším případě
     * - Pomalý na velkých náhodných polích
     */

    public static int[] insertSort(int[] data) {
        comparisons = 0;
        swaps = 0;
        int[] arr = data.clone();

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    swaps++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
            if (j < i - 1) swaps++;
        }

        return arr;
    }

    /**
     * Průměr - Θ(nlogn)
     * Nejlepší - vyberu si medián pivotu - Θ(nlogn)
     * jak zjistíme medián: 50% zacatku a 50% konce a mam median - záměrně upravovat algoritmus na - je to ale neefektivní
     * Nejhorší- vyberu si nejmenší nebo nejvetší hodnotu pivotu - O(n**2)
     * 
     * dalo by se to udelat, že na velká pole se použije iterace a na malá pole se použije rekurze - melo by to nemít jakoby tu quadratickou slozitost 
     * v nejhorsím casu pointeru by mela pamet stacku rust az linearně.
     * Existuje iterativní standart - nemělo by se v aplikacich používat rekurzivni program kvůli pádu aplikace
     * Rekursive stack is O(log n)
     * byl to jako shitflow ty podminky a jak to posutit jako tady 
    */

    /**
     * QUICK SORT - Řazení rozdělováním (Rozděl a panuj)
     *
     * PRINCIP ALGORITMU:
     * Rekurzivní algoritmus typu "rozděl a panuj":
     * 1. Vybereme PIVOT 
     * 2. Rozdělíme prvky: levá strana < pivot, pravá strana > pivot
     * 3. Prvky se posunují tak, aby byly na správné straně
     * 4. Rekurzivně aplikujeme na levou a pravou část
     *
     * Příklad: [5,2,8,1,9,4,7,3]
     *   Pivot = 1 (prvek uprostřed)
     *   Procházíme zleva a zprava, hledáme prvky na špatné straně
     *   Vyměňujeme je, dokud se indexy nesetkají
     *   Výsledek: prvky < 1 vlevo, prvky > 1 vpravo
     *   Pak rekurzivně na obě části
     *
     * ČASOVÁ SLOŽITOST:
     *
     * NEJLEPŠÍ PŘÍPAD: Θ(n log n)
     *   Kdy: Pivot je vždy medián (střední hodnota)
     *   Pole se dělí na poloviny → log₂(n) úrovní dělení
     *   Na každé úrovni n porovnání
     *   Celkem: n * log₂(n) porovnání
     *
     *   Příklad n=16: log₂(16)=4 úrovně
     *   Úroveň 1: 16 prvků, 16 porovnání
     *   Úroveň 2: 2x8 prvků, 16 porovnání
     *   Úroveň 3: 4x4 prvky, 16 porovnání
     *   Úroveň 4: 8x2 prvky, 16 porovnání
     *   CELKEM: 16*4 = 64 porovnání
     *
     * PRŮMĚRNÝ PŘÍPAD: Θ(n log n)
     *   Při náhodném výběru pivotu se v průměru chová jako nejlepší
     *
     * NEJHORŠÍ PŘÍPAD: O(n²)
     *   Kdy: Pivot je VŽDY nejmenší nebo největší prvek
     *   Pole se dělí na n-1 a 1 prvek → n úrovní (lineárně!)
     *   Úroveň 1: n prvků, n porovnání
     *   Úroveň 2: n-1 prvků, n-1 porovnání
     *   Úroveň 3: n-2 prvků, n-2 porovnání
     *   ...
     *   CELKEM: n+(n-1)+(n-2)+...+1 = n*(n+1)/2 ≈ 1/2*(n²)
     *
     *   Příklad n=100, nejhorší: ~5000 porovnání!
     *   To je stejně špatné jako Bubble Sort!
     *
     * ODVOZENÍ VZORCE:
     * Nejlepší: log₂(n) úrovní, každá úroveň n operací → n*log₂(n)
     * Nejhorší: Součet n+(n-1)+...+1 = n*(n+1)/2
     *
     * PROSTOROVÁ SLOŽITOST:
     * - Nejlepší: O(log n) - vyvážený rekurzivní strom
     * - Nejhorší: O(n) - degenerovaný strom (skoro lineární)
     * Kvůli rekurzivnímu zásobníku (call stack)
     *
     * VÝHODY:
     * -Nejrychlejší v PRŮMĚRU Θ(n log n)
     * -In-place řazení (malá dodatečná paměť)
     * -Velmi praktický - používá se v reálných aplikacích
     *
     * NEVÝHODY:
     * - Může být O(n²) v nejhorším případě
     * - Složitější na pochopení než Bubble/Insert Sort
     * - Není stabilní (nemůže zachovat pořadí stejných prvků)
     */

    public static int[] quickSort(int[] data) {
        comparisons = 0;
        swaps = 0;
        int[] arr = data.clone();
        quickSortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSortHelper(int[] arr, int leftIndex, int rightIndex) {
        int pivot = arr[(leftIndex + rightIndex) / 2];
        int i = leftIndex;
        int j = rightIndex;

        while (i <= j) {
            while (arr[i] < pivot) {
                comparisons++;
                i++;
            }
            while (arr[j] > pivot) {
                comparisons++;
                j--;
            }
            comparisons++;
            if (i <= j) {
                swap(arr, i, j);
                swaps++;
                i++;
                j--;
            }
        }

        if (leftIndex < j) {
            quickSortHelper(arr, leftIndex, j);
        }
        if (i < rightIndex) {
            quickSortHelper(arr, i, rightIndex);
        }
    }

    // Swap class - optimalizace
    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String filename = "/home/formijan/Downloads/Algoritmy/data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            System.out.println(filename);

            String line;
            int runNumber = 1;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                try {
                    int size = Integer.parseInt(line);
                    line = br.readLine();

                    if (line == null) {
                        System.err.println("CHYBA: Chybí data pro velikost " + size);
                        continue;
                    }

                    String[] elements = line.trim().split("\\s+");
                    int[] data = new int[elements.length];

                    for (int i = 0; i < elements.length; i++) {
                        data[i] = Integer.parseInt(elements[i]);
                    }

                    // Bubble Sort
                    int[] bubbleResult = bubbleSort(data);
                    System.out.println("RUN " + runNumber + " - BubbleSort : COMPARASIONS " + comparisons + " -> SWAPS " + swaps);
                    System.out.println("  -> SORTED_DATA: " + arrayToString(bubbleResult));

                    // Insert Sort
                    int[] insertResult = insertSort(data);
                    System.out.println("RUN " + runNumber + " - InsertSort : COMPARASIONS " + comparisons + " -> SWAPS " + swaps);
                    System.out.println("  -> SORTED_DATA: " + arrayToString(insertResult));

                    // Quick Sort
                    int[] quickResult = quickSort(data);
                    System.out.println("RUN " + runNumber + " - QuickSort : COMPARASIONS " + comparisons + " -> SWAPS " + swaps);
                    System.out.println("  -> SORTED_DATA: " + arrayToString(quickResult));

                    runNumber++;

                } catch (NumberFormatException e) {
                    System.err.println("CHYBA: NumberFormatException - Neplatný vstup");
                    e.printStackTrace(System.err);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("CHYBA: FileNotFoundException - Soubor nenalezen: " + filename);
            e.printStackTrace(System.err);
        } catch (IOException e) {
            System.err.println("CHYBA: IOException - Chyba při čtení: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}