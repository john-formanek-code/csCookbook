
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NactiDelimiter {
    public static void main(String[] args) throws  FileNotFoundException{
        // vytvorime instanci tridy Scanner
        File vstup = new File(".\\data\\data_delimiter.txt");
        Scanner ctecka = null;

        if(vstup.exists()) {
            ctecka = new Scanner(vstup);
            ctecka.useDelimiter(",");
        }

        while(ctecka.hasNext()) {           
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