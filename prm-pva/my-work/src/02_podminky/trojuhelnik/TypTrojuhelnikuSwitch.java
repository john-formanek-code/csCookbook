import java.util.Scanner;

public class trojuhelnik1 {

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

            switch (shoda) {
                case 0:
                    System.out.print("Trojuhelnik je platný");
                    break;
                case 1:
                    System.out.print("Trojuhelnik je rovnoramený");
                    break;
                case 3:
                    System.out.print("Trojuhelnik je rovnosraný");
                    break;
                default:
                    System.out.print("NĚCO HODNĚ ŠPATNĚ, PŘEMÝŠLEJ");
                    break;
            }

        } else {
            System.out.print("Trojuhelnik neni platny");

            scanner.close();

        }

    }

}
