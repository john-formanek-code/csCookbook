
import java.io.FileWriter;
import java.io.IOException;

public class Zapis4_ppm_grayscale{
    public static void main(String[] args) throws IOException{
        FileWriter zapis = new FileWriter("obrazek2.ppm", false);

        int sirka = 8;
        int vyska = 8;

        //Hlavicka P1-P3
        //P1 - Cerno-bila (1-0)
        //P2 - Odstiny sede
        //P3 - Barevny
        zapis.write("P2\n");
        //Rozliseni sirka vyska
        zapis.write(sirka + " " + vyska + "\n");
        //Maximalni hodnota
        zapis.write((sirka * vyska) + "\n");

        //Iteruj pres vsechny pixely
        for (int i = 0; i < vyska; i++) { // RADKY
            for (int j = 0; j < sirka; j++) { // PIXELY V RADKU
                zapis.write((i + j) * 4 + " ");
                //zapis.write((i * j) + " ");
            }
            zapis.write("\n");
        }

        //Vynut zapsani dat do souboru
        zapis.flush();
        //Uzavri soubor
        zapis.close();
    }
}