/*
vygenerujete 100 čísel v rozmezi -5000 až 5000 do pole najdete v tom poli kolik - 3. největší číslo - kolik se rovná 3 největší číslo
musim nejak overeti duplicity a volat nejaky sort algo 
not a big deal
*/
import java.util.Arrays;
import java.util.Random;

public class Ukol2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] pole = new int[100];

        for (int i = 0; i < pole.length; i++) {
            pole[i] = rnd.nextInt(10001) - 5000;
        }

        // sort
        int[] serazene = Arrays.copyOf(pole, pole.length);
        Arrays.sort(serazene);

        //overeni duplicit - aby nebyly 2 3. nejvetší čísla
        Integer tretiNejvetsi = null;
        int pocetRuznych = 0;
        for (int i = serazene.length - 1; i >= 0; i--) {
            if (i == serazene.length - 1 || serazene[i] != serazene[i + 1]) {
                pocetRuznych++;
                if (pocetRuznych == 3) {
                    tretiNejvetsi = serazene[i];
                    break;
                }
            }
        }

        //kontrola
        if (tretiNejvetsi == null) {
            System.out.println("V poli nejsou 3 ruzne hodnoty.");
            return;
        }
        int pocet = 0;
        for (int cislo : pole) {
            if (cislo == tretiNejvetsi) {
                pocet++;
            }
        }

        System.out.println("3. nejvetsi cislo je: " + tretiNejvetsi);
        System.out.println("Pocet vyskytu (duplication check): " + pocet);
    }
}
