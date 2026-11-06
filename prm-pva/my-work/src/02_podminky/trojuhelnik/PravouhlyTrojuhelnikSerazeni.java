import java.util.Scanner;

public class PravTrojMax {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int pom;

        System.out.print("Zadej hodnotu a: ");
        int a = scanner.nextInt();

        System.out.print("Zadej hodnotu b: ");
        int b = scanner.nextInt();

        System.out.print("Zadej hodnotu c: ");
        int c = scanner.nextInt();

        if (a + b > c && a + c > b && b + c > a) { // je to tr

            if (a > b) {
                pom = a;
                a = b;
                b = pom;
            }

            if (b > c) {
                pom = b;
                b = c;
                c = pom;
            }
            
            if ((a * a + b * b == c * c)) {
                System.out.print("Trojuhelnik je pra");
            } else {
                System.out.print("neni to pravohly");
            }

        } else {
            System.out.print("Trojuhelnik neni platny");

            scanner.close();

        }

    }
}
