import java.io.File;
import java.io.IOException;

public class Soubor{

    /**
     * Program vytvori instanci tridy file a pote,
     * pokud existuje - smaze ho
     * pokud neexistje - vytvori ho
     * 
     * @param args - pole vstupnich argumentu programu
     * 
     * @return void
     * 
     */
    public static void main(String[] args) throws IOException{
        // Vytvorime instanci tridy file
        File vstupniSoubor = new File(".\\data\\data2.txt");

        /*
            Pokud soubor existuje - smazeme ho
            Pokud neexistje - vytvor ho
        */
        if(vstupniSoubor.exists()) {
            System.out.println("Soubor existuje");
            vstupniSoubor.delete();
        } else {
            System.out.println("Soubor NEexistuje");
            vstupniSoubor.createNewFile();
        }

        System.exit(0); // vse ok
        
        //System.err.println("Popis chyby");
        //System.exit(<1 - 127>); // errorove kody       
    }
}