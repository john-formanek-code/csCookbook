//přesuny - n-1 O(n)
// porovnání - (n-1)+(n-2)... - 1/2 *(n*n -n ) - O(n*n)

package listopad;

public class SelectSort {
    public static int[] selectSort(int[] data){
        for(int i =0; i< data.length -1; i++){
            int minValueIndex = i;
            for(int j=i +1; j< data.length; j++){
                if(data[j] < data[minValueIndex]){
                    minValueIndex = j;
                }
            }
            int pom = data[minValueIndex];
            data[minValueIndex] = data[i];
            data[i] = pom;
        }
            
        return data;
    }


    public static void main(String[] args) {
        int[] data = { 5, 8, 6, 7, 9, 1, 2, 3, 5, 0, 8, 7, 9 };
    
            int[] serazeno = new int[data.length];
            serazeno = selectSort(data);

            for(int cislo: serazeno) {
                System.out.print(cislo + ", ");
            }
    }
}
