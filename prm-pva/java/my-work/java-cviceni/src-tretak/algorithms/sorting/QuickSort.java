package listopad;

public class QuickSort {

    public static void quickSort(int[] data, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;

        int i = leftIndex;
        int j = rightIndex;
        int pivot = data[(leftIndex + rightIndex) / 2];

        while (i <= j) {
            while (data[i] < pivot) i++;
            while (data[j] > pivot) j--;

            if (i <= j) {
                int pom = data[i];
                data[i] = data[j];
                data[j] = pom;
                i++;
                j--;
            }
        }

        if (leftIndex < j)
            quickSort(data, leftIndex, j);
        if (i < rightIndex)
            quickSort(data, i, rightIndex);
    }

    public static void main(String[] args) {
        int[] data = {5, 8, 6, 7, 9, 1, 2, 3, 5, 0, 8, 7, 9};

        quickSort(data, 0, data.length - 1);

        for (int cislo : data) {
            System.out.print(cislo + ", ");
        }
    }
}
