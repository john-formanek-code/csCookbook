import java.util.Scanner;

public class PravTrojCZ {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Zadej hodnotu a: ");
        int a = scanner.nextInt();

        System.out.print("Zadej hodnotu b: ");
        int b = scanner.nextInt();

        System.out.print("Zadej hodnotu c: ");
        int c = scanner.nextInt();

        if (a + b > c && a + c > b && b + c > a) { // je to tr

            if ((a*a+b*b==c*c) || (b*b+c*c==a*a) || (c*c+a*a==b*b) ){
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
