
import java.io.FileWriter;
import java.io.IOException;

public class Zapis{
    public static void main(String[] args) throws IOException{
        //Vytvorime instanci tridy FileWriter
        //argumenty <cesta k soubory, append souboru>
        FileWriter zapis = new FileWriter("out1.txt", false);

        int cislo = 20;

        //Zapsani dat do souboru
        zapis.write("Ahoj\n");
        zapis.write("Ahoj\n");
        zapis.write("Ahoj\n");
        //Cisla je potreba prevest na retezec - jinak jsou zapsany binarne
        zapis.write(cislo + "\n");
        zapis.write(Integer.toString(cislo)); //to je do integeru aby to fungovalo atd a to chcia a

        //Vynut zapsani dat do souboru
        zapis.flush();
        //Uzavri soubor
        zapis.close();

        // TOTO NELZE !!! - uz jsme uzavřeli zápisový proud
        //zapis.write("XXXX");
    }
}