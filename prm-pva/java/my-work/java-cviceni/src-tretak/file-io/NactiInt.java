

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NactiInt {
    public static void main(String[] args) throws FileNotFoundException {
        // vytvoříme instanci třídy scanner
        File vstup = new File("pokusy/src/zari/data/data.txt");
        Scanner ctecka = null;

        if (vstup.exists()) {
            ctecka = new Scanner(vstup);
        } else {
            return;
        }
        // dokud souor obsahuje data nacitame
        while (ctecka.hasNext()) {
            /*
             * pokud je int - nacita jako int
             * pokud neni - nacita jako string
             */
            if (ctecka.hasNextInt()) {
                int data = ctecka.nextInt();
                System.out.println("Nacten int: " + data);
            } else {
                String data = ctecka.next();
                System.out.println("Nacten jiny datovy typ: " + data);
            }

        }

        System.out.println("Soubor docten");
        ctecka.close();
    }
}
