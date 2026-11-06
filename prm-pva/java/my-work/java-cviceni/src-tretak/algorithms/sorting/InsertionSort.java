/* Porovnávání - 1/2 (n*n -n)
 * 
 * Přesuny - 1/2 (n*n + n -2)
 */

package listopad;

public class InsertionSort {
    public static int[] insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) { // začínáme od 1 protože první prvek v poli považujeme za seřazený
            int key = data[i];
            int j = i - 1;

            while ((j >= 0) && (data[j] > key)) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
        return data;
    }

    public static int callSelf(int count){
        System.out.println("IN count: " + count);
        callSelf(++count);
        System.out.println("OUT count: " + count);
        return 1;

    }

    public static void main(String[] args) {
       /* int[] data = { 5, 8, 6, 7, 9, 1, 2, 3, 5, 0, 8, 7, 9 };

        int[] serazeno = new int[data.length];
        serazeno = insertSort(data);

        for (int cislo : serazeno) {
            System.out.print(cislo + ", ");
        }
     }*/
     callSelf(0);
}}
