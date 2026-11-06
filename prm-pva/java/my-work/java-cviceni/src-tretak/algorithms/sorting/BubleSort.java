//[4,5,9,2]
// 3 posuny
// 3 porovnávání
// ubíráme o jeden prvek porovnávání
// 1/2 * (n*n-n)




package listopad;

public class BubleSort {
    static int[] bubbleSort(int[] data) {
            for (int i = 0; i < data.length - 1; i++) {
                for (int j = 0; j < data.length - i - 1; j++) {
                    if (data[j] > data[j + 1]) {
                        int tem = data[j];
                        data[j] = data[j+1];
                        data[j +1] = tem; 
    
                    
                    }
                }
            }
    
            return data;
        }
    
        public static void main(String[] args) {
            int[] data = { 5, 8, 6, 7, 9, 1, 2, 3, 5, 0, 8, 7, 9 };
    
            int[] serazeno = new int[data.length];
            serazeno = bubbleSort(data);

            for(int cislo: serazeno) {
                System.out.print(cislo + ", ");
            }
    }
}
