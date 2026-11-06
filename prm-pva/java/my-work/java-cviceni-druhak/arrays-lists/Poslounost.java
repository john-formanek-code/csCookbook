package duben;

 import java.util.Random;
 
 
 public class Poslounost {
   
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] posloupnost = new int[50];

        posloupnost[0] = rnd.nextInt(10) + 1; // Začátek od 1–10

        for (int i = 1; i < posloupnost.length; i++) {
            // Přičteme náhodné číslo mezi 1 a 10 k předchozímu
            posloupnost[i] = posloupnost[i - 1] + rnd.nextInt(10) + 1;
        }

        // Výpis posloupnosti
        System.out.println("Náhodná vzestupná posloupnost 50 čísel:");
        for (int cislo : posloupnost) {
            System.out.print(cislo + " ");
        }
    }
}


