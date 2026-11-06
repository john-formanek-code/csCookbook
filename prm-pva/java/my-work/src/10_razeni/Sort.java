public class Sort {
    int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // if the current element is greater than the next element
                    int temp = arr[j]; // swap the elements
                    arr[j] = arr[j + 1]; // swap the elements
                    arr[j + 1] = temp; // swap the elements
                }   
            }
        }
        return arr;
        //min: ()
        //max:()
        
    }
   
    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 5, 6, 763, 33};
        Sort s = new Sort();
        s.bubbleSort(arr);
        System.out.println("Array after sorting: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }
}