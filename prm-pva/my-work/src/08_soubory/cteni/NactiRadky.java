
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NactiRadky {
    public static void main(String[] args) throws FileNotFoundException {
        // vytvoříme instanci třídy scanner
        File vstup = new File("pokusy/src/zari/data/data_lines.txt");
        Scanner ctecka = null;

        if (vstup.exists()) {
            ctecka = new Scanner(vstup);
            ctecka.useDelimiter(",");
        } else {
            return;
        }

        while (ctecka.hasNextLine()) {
            String data = ctecka.nextLine();
            System.out.println("Nacten radek: " + data);
            String[] poleRetezcu = data.split(",");

            for (int i = 0; i < poleRetezcu.length; i++) {
                System.out.println("Element: " + poleRetezcu[i]);
            }
        }

        System.out.println("Soubor docten");
        ctecka.close();
    }
}
