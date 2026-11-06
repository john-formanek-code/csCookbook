

import java.util.Scanner;

public class Alg {
    public static void VypisRadek(int sirka) {
        for(int i=0; i< sirka; i++){
        System.out.print("*");
        }
    }

    public static int NactiKladneCislo (Scanner sc) {
        int cislo = sc.nextInt();

        while( cislo <= 0){
            System.out.println("Zadej kladne cislo:");
            cislo = sc.nextInt();
        }
        return cislo;
    }

    public static void main(String[] args) {

        Scanner ctecka = new Scanner(System.in);

        int x = NactiKladneCislo(ctecka);
        for (int j = 0; j < x; j++) {
            VypisRadek(x);
            System.out.println("");
        }
    }
}
