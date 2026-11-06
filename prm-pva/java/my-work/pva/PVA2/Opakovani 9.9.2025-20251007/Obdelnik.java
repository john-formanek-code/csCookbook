
import java.util.Scanner;

public class Obdelnik {
    // Jednoradkovy komentar
   
    /*
    Víceradkovy komentar
    */

   /**
    * Dokumentacni komentar
    */

    public static void VypisRadek(int sirka) {
        for(int i = 0; i < sirka; i++) {
            System.out.print("*");
        }
        
        System.out.println("");
    }

    public static int NactiKladneCislo(Scanner sc) {
        int cislo = sc.nextInt();

        while( cislo <= 0) {
            System.out.println("Zadej kaldne cislo: ");
            cislo = sc.nextInt();
        }

        return cislo;
    }

    public static void main(String[] args) {
        //final int VYSKA = 10;
        //final int SIRKA = 30;

        Scanner ctecka = new Scanner(System.in);

        int x = NactiKladneCislo(ctecka);
        int y = NactiKladneCislo(ctecka);

        for(int j = 0; j < y; j++) {
            /*for(int i = 0; i < x; i++) {
                System.out.print("*");
            }*/

            VypisRadek(x);
        }
    }
}