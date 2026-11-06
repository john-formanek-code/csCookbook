package rijen;

public class Bisekce {
    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int hledane = 5;

        binarni(data, 0);
        System.out.println("Hledane cislo nalezeno? " + hledane + "-> nalezeno: " + binarni(data, hledane));
    }

    public static boolean binarni(int[] data, int hledane) {
        int left = 0;
        int right = data.length - 1;

        int middle = 0;
        int steps = 1;

        do {
            middle = (left + right) / 2;
            if (data[middle] == hledane) {
                System.out.println("Nalezeno");
                return true;
            }

            if (data[middle] < hledane) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            steps++;


        } while (left <= right);
        System.out.println(steps);

        return false;
    }
}