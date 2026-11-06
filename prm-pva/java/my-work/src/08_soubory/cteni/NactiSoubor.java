

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NactiSoubor {
    public static void main(String[] args) throws FileNotFoundException {
        // Použij relativní cestu (vzhledem k pracovnímu adresáři)
        File vstup = new File("pokusy/src/zari/data/data.txt");

        if (!vstup.exists()) {
            System.out.println("Soubor neexistuje: " + vstup.getAbsolutePath());
            return;
        }

        // Soubor existuje, můžeme číst
        Scanner ctecka = new Scanner(vstup);

        if (ctecka.hasNext()) {
            String data = ctecka.next();
            System.out.println("Načtený text: " + data);
        } else {
            System.out.println("Soubor je prázdný");
        }

        ctecka.close(); // nezapomeň uzavřít Scanner
    }
}
