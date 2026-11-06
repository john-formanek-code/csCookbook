public class Priklad2 {
    public static void main(String[] args) {
        System.out.print("Trojciferná symetrická čísla:");

        for (int i = 100; i <= 999; i++) {
            int jednotky = i % 10;
            int stovky = i / 100;
            if (jednotky == stovky) {
                System.out.println(i);
            }
        }

    }
}
