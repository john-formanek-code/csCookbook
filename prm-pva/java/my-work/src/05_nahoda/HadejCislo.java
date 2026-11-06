package IT;

import java.util.Random;
import java.util.Scanner;

public class HadejCislo {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);
        int nahodny = rnd.nextInt(499) + 1;
        int a = 0;

        System.out.println("Jaké číslo si myslím?");

        while (a != nahodny) {
            System.out.print("Zadej číslo: ");
            a = scan.nextInt();

            if (a > nahodny) {
                System.out.println("Myšlené číslo je menší.");
            } else if (a < nahodny) {
                System.out.println("Myšlené číslo je větší.");
            } else {
                System.out.println("Správně, myšlené číslo je: " + nahodny);
            }
        }

        scan.close();
    }
}
