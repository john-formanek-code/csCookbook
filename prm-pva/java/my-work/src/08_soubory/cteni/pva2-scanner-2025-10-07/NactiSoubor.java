
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class NactiSoubor {
    public static void main(String[] args) throws  FileNotFoundException{
        File vstup = new File(".\\data\\data.txt");
        Scanner ctecka = null;

        if(vstup.exists()) {
            ctecka = new Scanner(vstup);
        }

        while(ctecka.hasNext()) {
            String data = ctecka.next();
            System.out.println(data);
        }

        System.out.println("Soubor docten");
        ctecka.close();
    }
}