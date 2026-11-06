
import java.util.Scanner;

public class Cisla {
    public static void main(String[] args) {
        Scanner ctecka = new Scanner(System.in);
        int n = ctecka.nextInt();
        ctecka.close();

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            for(int j = 1; j <= i; j++) {
                System.out.print( (i * j) + " ");
            }
            System.out.println("");
        }
    }
}