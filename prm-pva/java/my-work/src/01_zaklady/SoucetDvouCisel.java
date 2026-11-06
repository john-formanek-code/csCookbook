
import java.util.Scanner;

public class ctiint2 {
    public static void main(String[] args) {
        System.out.println("Napiš první číslo:");

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();

        System.out.println("Napiš druhé číslo:");
        int b = scan.nextInt();
        scan.close();

        System.out.println("Výsledek součtu " +a+ "+" +b+"="+(a+b));
        System.out.println(a + b);
    }

}
