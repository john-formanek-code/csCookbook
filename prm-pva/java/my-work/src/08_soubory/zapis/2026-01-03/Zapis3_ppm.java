
import java.io.FileWriter;
import java.io.IOException;

public class Zapis3_ppm{
    public static void main(String[] args) throws IOException{
        FileWriter zapis = new FileWriter("obrazek1.ppm", false);

        int sirka = 5;
        int vyska = 5;

        //Hlavicka P1-P3
        //P1 - Cerno-bila (1-0)
        //P2 - Odstiny sede
        //P3 - Barevny
        zapis.write("P1\n");
        //Rozliseni sirka vyska
        zapis.write(sirka + " " + vyska + "\n");
        //Maximalni hodnota
        //zapis.write("\n");

        //Iteruj pres vsechny pixely
        for (int i = 0; i < vyska; i++) { // RADKY
            for (int j = 0; j < sirka; j++) { // PIXELY V RADKU
                zapis.write((j % 2) + " ");
            }
            zapis.write("\n");
        }

        //Vynut zapsani dat do souboru
        zapis.flush();
        //Uzavri soubor
        zapis.close();
    }
}