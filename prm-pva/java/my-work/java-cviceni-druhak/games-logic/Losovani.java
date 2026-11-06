

import java.util.Random;

public class Losovani {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] pole = new int[20];

        // Naplnění pole čísly 1 až 20
        for (int i = 0; i < pole.length; i++)
            pole[i] = i + 1;

        // Míchání
        for (int i = 0; i < pole.length; i++) {
            int kamarad = rnd.nextInt(20);
            int pomocna = pole[i];
            pole[i] = pole[kamarad];
            pole[kamarad] = pomocna;
        }
 
        // Výpis výsledného pole
        for (int i = 0; i < pole.length; i++) 
            System.out.print(pole[i] + " ");
    }
}
