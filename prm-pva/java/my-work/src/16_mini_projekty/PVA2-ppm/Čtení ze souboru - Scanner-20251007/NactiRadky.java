
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class NactiRadky {
    public static void main(String[] args) throws  FileNotFoundException{
        // vytvorime instanci tridy Scanner
        File vstup = new File(".\\data\\data_lines.txt");
        Scanner ctecka = null;

        if(vstup.exists()) {
            ctecka = new Scanner(vstup);
        }

        // Dokud soubor obsahuje data, nacitame
        while(ctecka.hasNextLine()) {          
            String data = ctecka.nextLine();
            System.out.println("Nacten radek: " + data);
            String[] poleRetezcu = data.split(",");

            for(int i = 0; i < poleRetezcu.length; i ++) {
                System.out.println("Element for:" + poleRetezcu[i]);
            }
            /*for(String element: poleRetezcu) {
                System.out.println("Element for-each :" + element);
            }*/
        }

        System.out.println("Soubor docten");
        ctecka.close();
    }
}