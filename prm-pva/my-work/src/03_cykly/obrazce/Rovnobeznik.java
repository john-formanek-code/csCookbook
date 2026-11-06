public class prvni {
    public static void main(String[] args) {
        final int ZLEVA = 20;
        // 1.faze - rozsireni
        for (int i = 1; i <= 20; i++) {

            // odsazeni
            for (int k = 1; k <= (5 - i) + ZLEVA; k++) {
                System.out.print(" ");
            }

            // hvezdy
            for (int j = 1; j <= 20; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
