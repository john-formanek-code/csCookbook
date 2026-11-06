import java.util.Scanner;

public class trojuhelnik {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Zadej hodnotu a: ");
        int a = scanner.nextInt();

        System.out.print("Zadej hodnotu b: ");
        int b = scanner.nextInt();

        System.out.print("Zadej hodnotu c: ");
        int c = scanner.nextInt();

        if (a + b > c && a + c > b && b + c > a) { // je to tr
            int shoda = 0;
            if (a == b)
                shoda++;
            if (b == c)
                shoda++;
            if (c == a)
                shoda++;

            if (shoda == 0) {
                System.out.print("Je to obecný troúhelník.");
            } else {
                if (shoda == 1) {
                    System.out.print("Je to rovnoramený trojúhelník.");
                } else {
                    System.out.print("Je to rovnostraný trojúhelník.");

                }
            }

        } else {
            System.out.print("Trojuhelnik neni platny");

            scanner.close();

        }

    }

}
