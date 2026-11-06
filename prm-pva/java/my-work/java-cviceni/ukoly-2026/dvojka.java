import java.util.Arrays;   // Kvůli kopírování a řazení pole
import java.util.Random;   // Kvůli generování náhodných čísel

public class dvojka {
    public static void main(String[] args) {

        // Vytvoření generátoru náhodných čísel
        Random rnd = new Random();

        // Vytvoření pole pro 100 celých čísel
        int[] pole = new int[100];

        // Naplnění pole 100 náhodnými čísly v rozsahu -5000 až 5000
        for (int i = 0; i < pole.length; i++) {
            pole[i] = rnd.nextInt(10001) - 5000;
            // nextInt(10001) vrátí číslo 0 až 10000
            // po odečtení 5000 dostaneme -5000 až 5000
        }

        // Vytvoříme kopii původního pole,
        // aby původní pole zůstalo zachované
        int[] serazene = Arrays.copyOf(pole, pole.length);

        // Seřazení kopie pole od nejmenšího po největší
        Arrays.sort(serazene);

        // Integer je objektový typ, takže může být null
        // Na začátku ještě nevíme, jaké je 3. největší číslo,
        // proto tam dáme null = zatím nenalezeno
        Integer tretiNejvetsi = null;

        // Počítadlo různých hodnot při průchodu od největších čísel
        int pocetRuznych = 0;

        // Projdeme seřazené pole odzadu,
        // protože na konci jsou největší čísla
        for (int i = serazene.length - 1; i >= 0; i--) {

            // Pokud jsme na posledním prvku,
            // nebo pokud je aktuální číslo jiné než číslo za ním,
            // našli jsme novou různou hodnotu
            if (i == serazene.length - 1 || serazene[i] != serazene[i + 1]) {
                pocetRuznych++;

                // Jakmile narazíme na 3. různou největší hodnotu,
                // uložíme ji a ukončíme cyklus
                if (pocetRuznych == 3) {
                    tretiNejvetsi = serazene[i];
                    break;
                }
            }
        }

        // Pokud jsme nenašli 3 různé hodnoty,
        // vypíšeme zprávu a ukončíme program
        if (tretiNejvetsi == null) {
            System.out.println("V poli nejsou 3 ruzne hodnoty.");
            return;
        }

        // Spočítáme, kolikrát se 3. největší číslo
        // vyskytuje v původním poli
        int pocet = 0;
        for (int cislo : pole) {
            if (cislo == tretiNejvetsi) {
                pocet++;
            }
        }

        // Výpis výsledku
        System.out.println("3. nejvetsi cislo je: " + tretiNejvetsi);
        System.out.println("Pocet vyskytu: " + pocet);
    }
}