import java.util.LinkedList;

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

    public static int[] insertSort(int[] data, int indexStart, int indexEnd) {
        for (int i = indexStart + 1; i <= indexEnd; i++) {
            int key = data[i];
            int j = i - 1;

            while ((j >= indexStart) && (data[j] > key)) {
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
            while (data[i] < pivot) {
                i++;
            }

            while (data[j] > pivot) {
                j--;
            }

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

    public static void quickSortIterative(int[] data) {
        LinkedList<Integer> indexes = new LinkedList<Integer>();
        indexes.push(0);
        indexes.push(data.length - 1);

        int leftI, rightI;

        while (!indexes.isEmpty()) { //indexes.size() > 0
            rightI = indexes.pop();
            leftI = indexes.pop();           
            
            if((rightI - leftI) <= 0) {
                continue;
            }

            int i = leftI, j = rightI;
            int pivot = data[(leftI + rightI) / 2];

            do {
                while (data[i] < pivot) {
                    i++;
                }
                while (data[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    int pom = data[i];
                    data[i] = data[j];
                    data[j] = pom;

                    i++;
                    j--;
                }

            } while (i < j);

            //quickSort(data, leftIndex, j);
            indexes.push(leftI);
            indexes.push(j);
            //quickSort(data, i, rightIndex);
            indexes.push(i);
            indexes.push(rightI);
        }
        
    }

    public static void quickSortIterativeOptimised(int[] data, int size) {
        LinkedList<Integer> indexes = new LinkedList<Integer>();
        indexes.push(0);
        indexes.push(data.length - 1);

        int leftI, rightI;

        while (!indexes.isEmpty()) { //indexes.size() > 0
            rightI = indexes.pop();
            leftI = indexes.pop();           
            
            if((rightI - leftI) <= 0) {
                continue;
            }

            int i = leftI, j = rightI;
            int pivot = data[(leftI + rightI) / 2];

            do {
                while (data[i] < pivot) {
                    i++;
                }
                while (data[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    int pom = data[i];
                    data[i] = data[j];
                    data[j] = pom;

                    i++;
                    j--;
                }

            } while (i < j);

            if((j - leftI + 1) > size) {
                //quickSort(data, leftIndex, j);
                indexes.push(leftI);
                indexes.push(j);
            } else {
                //call InsertSort();
                insertSort(data, leftI, j);
            }

            if((rightI - i + 1) > size) {
                //quickSort(data, i, rightIndex);
                indexes.push(i);
                indexes.push(rightI);
            } else {
                //call InsertSort();
                insertSort(data, i, rightI);
            }
        }
        
    }

    public static void main(String[] args) {
        int[] data = new int[100];
        int timeSum = 0;
        int repetitionCount = 10;

        for (int j = 0; j < repetitionCount; j++) {
            for(int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100);
            }

            long timeStart = System.nanoTime();
            quickSortIterativeOptimised(data, 10);
            //insertSort(data, 0, 5);
            long timeEnd = System.nanoTime();

            System.out.println("Run: " + j + " -> duration: " + (timeEnd - timeStart));
            timeSum += (timeEnd - timeStart);
        }

        System.out.println("Avg: " + (timeSum / repetitionCount));
    }
}
