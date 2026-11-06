public class Hvezdy1 {

    public static void main(String[] args) {
        // 1 cast
        for (int i = 0; i < 20; i++) {
            System.out.print("*");
        }
        System.out.println();

        // 2 cast
        for (int drak = 0; drak < 18; drak++) {
            System.out.print("*");
            for (int i = 0; i < 18; i++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }

        // 3 cast
        for (int i = 0; i < 20; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}