

import java.io.File;
import java.io.IOException;

public class Soubor {
    public static void main(String[] args) throws IOException {
        File vstupniSoubor = new File("pokusy/src/zari/data/data.txt");

        if (vstupniSoubor.exists()) {
            System.out.println("Soubor existuje");
            vstupniSoubor.delete();
        } else {
            System.out.println("Soubor neexistuje");
            vstupniSoubor.createNewFile();
        }
    }
}
