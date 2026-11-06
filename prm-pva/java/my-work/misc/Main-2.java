import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "test.txt";
        Path path = Paths.get(fileName);

        if (!Files.isRegularFile(path)) {
            System.err.println("Input error: file \"" + fileName + "\" does not exist.");
            return;
        }

        try (Scanner scanner = new Scanner(path)) {
            System.out.println(path.getFileName());

            int run = 0;
            while (scanner.hasNext()) {
                if (!scanner.hasNextInt()) {
                    System.err.println("Input error: expected array size, got \"" + scanner.next() + "\".");
                    return;
                }

                int size = scanner.nextInt();
                if (size < 0) {
                    System.err.println("Input error: array size must be non-negative.");
                    return;
                }

                if (!scanner.hasNextInt()) {
                    System.err.println("Input error: missing searched number.");
                    return;
                }
                int target = scanner.nextInt();

                int[] data = new int[size];
                for (int i = 0; i < size; i++) {
                    if (!scanner.hasNextInt()) {
                        System.err.println("Input error: missing value for array element #" + (i + 1) + ".");
                        return;
                    }
                    data[i] = scanner.nextInt();
                }

                boolean sorted = isSortedAscending(data);
                boolean found = sorted ? binarySearch(data, target) : linearSearch(data, target);
                String method = sorted ? "Binary" : "Bruteforce";

                run++;
                System.out.println("RUN " + run + " - " + method + " : " + target + " -> " + found);
            }


        } catch (IOException e) {
            System.err.println("Input error: cannot read file \"" + fileName + "\" (" + e.getMessage() + ").");
        }
    }

    private static boolean isSortedAscending(int[] data) {
        for (int i = 1; i < data.length; i++) {

            if (data[i - 1] > data[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Binary search - sorted array
     * Time complexity - O (log n) 
     * Space complexity - O(1) - pokud není použita žádná pomocná paměť
     *
     * @param data  - input array
     * @param target  - value to find
     * @return {@code true} when the value is present in the array
     */


    private static boolean binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int value = data[middle];

            if (value == target) {
                return true;
                
            } else if (value < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    /**
     * Linear brute-force - unsorted array
     * Time complexity - O(n) 
     * Space complexity - O(1) - pokud není použita žádná pomocná paměť
     *
     * 
     * 
     * @param data   input array
     * @param target value to find
     * @return {@code true} when the value is present in the array
     */


    private static boolean linearSearch(int[] data, int target) {
        for (int value : data) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}
