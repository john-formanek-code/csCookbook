
public class Sorts {
    public static int[] bubbleSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int pom = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = pom;
                }
            }
        }

        return data;
    }

    public static int[] bubbleSortSortedCheck(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int pom = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = pom;

                    swapped = true;
                }
            }

            if (!swapped) {
                return data;
            }
        }

        return data;
    }

    public static int[] selectSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minValueIndex]) {
                    minValueIndex = j;
                }
            }

            int pom = data[minValueIndex];
            data[minValueIndex] = data[i];
            data[i] = pom;
        }

        return data;
    }

    public static int[] insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
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

    public static int callSelf(int count) {
        System.out.println("IN count: " + count);

        callSelf(++count);

        System.out.println("OUT count: " + count);
        return 1;
    }

    public static int callSelfEnd(int count) {
        System.out.println("IN count: " + count);

        if (count < 10) {
            callSelfEnd(++count);
        }

        System.out.println("OUT count: " + count);
        return 1;
    }

    public static void quickSort(int[] data, int leftIndex, int rightIndex) {
        if((rightIndex - leftIndex) <= 0) {
            return;
        }

        int i = leftIndex, j = rightIndex;
        int pivot = data[(leftIndex + rightIndex) / 2];

        do {
            while (data[i] < pivot) i++;
            while (data[j] > pivot) j--;

            if (i <= j) {
                int pom = data[i];
                data[i] = data[j];
                data[j] = pom;

                i++;
                j--;
            }

        } while (i < j);

        quickSort(data, leftIndex, j);
        quickSort(data, i, rightIndex);
    }

    public static void main(String[] args) {
        //int[] data = {5, 8, 6, 7, 9, 1, 2, 3, 5, 0, 8, 7, 9};

        int[] data = {
            73, 5, 48, 12, 67, 94, 2, 58, 36, 81,
            29, 96, 15, 50, 88, 9, 63, 27, 71, 42,
            98, 33, 6, 84, 19, 55, 46, 91, 10, 69,
            24, 79, 1, 60, 38, 87, 13, 53, 32, 95,
            22, 75, 8, 65, 44, 99, 17, 57, 31, 82,
            4, 72, 28, 93, 14, 49, 35, 85, 21, 61,
            40, 89, 7, 68, 26, 74, 3, 59, 37, 92,
            16, 51, 30, 86, 20, 64, 43, 97, 11, 56,
            34, 83, 18, 62, 45, 90, 0, 70, 25, 78,
            23, 76, 39, 80, 41, 77, 52, 47, 54, 66
        };

        for (int cislo : data) {
            System.out.print(cislo + ", ");
        }
        System.out.println("");

        quickSort(data, 0, data.length - 1);

        for (int cislo : data) {
            System.out.print(cislo + ", ");
        }
        System.out.println("");

        //callSelfEnd(0);
    }
}
