
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NactiTypy {
    public static void main(String[] args) throws  FileNotFoundException{
        // vytvorime instanci tridy Scanner
        File vstup = new File(".\\data\\data_typy.txt");
        Scanner ctecka = null;

        if(vstup.exists()) {
            ctecka = new Scanner(vstup);
            ctecka.useDelimiter(",");
        }

        while(ctecka.hasNext()) {           
            if (ctecka.hasNextInt()) {
                int data = ctecka.nextInt();
                System.out.println("Nacten int: " + data);
            } else if (ctecka.hasNextBoolean()) {
                Boolean data = ctecka.nextBoolean();
                System.out.println("Nacten bool: " + data);
            } else if (ctecka.hasNextFloat()) {
                float data = ctecka.nextFloat();
                System.out.println("Nacten float: " + data);
            } else {
                String data = ctecka.next();
                System.out.println("Nacten jiny datovy typ: " + data);
            }
        }

        System.out.println("Soubor docten");
        ctecka.close();
    }
}