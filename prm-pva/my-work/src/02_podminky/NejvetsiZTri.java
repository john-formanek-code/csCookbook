import java.util.Scanner;

public class Vetsi2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zadej první cislo: ");
        int a = scanner.nextInt();
        System.out.print("Zadej druhe cislo: ");
        int b = scanner.nextInt();
        System.out.print("Zadej treti cislo: ");
        int c = scanner.nextInt();

        if (a < b) {
            if (b < c) {
                System.out.println(c);
            } else {
                System.out.println(b);
            }
        } else {
            if (a < c) {
                System.out.println(c);
            } else {
                System.out.println(a);
            }
        }
        scanner.close();
    }
}
