import java.util.Arrays;
import java.util.Random;

public class Ukol2New {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] pole = new int[100];

        // 1) Vygeneruj 100 cisel do pole
        for (int i = 0; i < pole.length; i++) {
            pole[i] = rnd.nextInt(10001) - 5000;
        }

        // 2) Serad pole a vezmi 3. nejvetsi cislo
        Arrays.sort(pole);
        int tretiNejvetsi = pole[pole.length - 3];

        // 3) Vypis vysledek
        System.out.println("3. nejvetsi cislo je: " + tretiNejvetsi);
    }
}
