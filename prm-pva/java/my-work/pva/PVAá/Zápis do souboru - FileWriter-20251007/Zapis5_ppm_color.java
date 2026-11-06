
import java.io.FileWriter;
import java.io.IOException;

public class Zapis5_ppm_color{
    public static void main(String[] args) throws IOException{
        FileWriter zapis = new FileWriter("obrazek3.ppm", false);

        int sirka = 8;
        int vyska = 8;
    
        //Hlavicka P1-P3       
        //P1 - Cerno-bila (1-0)
        //P2 - Odstiny sede
        //P3 - Barevny
        zapis.write("P3\n");
        //Rozliseni sirka vyska
        zapis.write(sirka + " " + vyska + "\n");
        //Maximalni hodnota
        zapis.write((sirka * vyska) + "\n");

        //Iteruj pres vsechny pixely
        for (int i = 0; i < vyska; i++) { // RADKY
            for (int j = 0; j < sirka; j++) { // PIXELY V RADKU
                zapis.write((j * 8) + " "); //RED
                zapis.write((i * 8) + " "); //GREEN
                zapis.write((i * j) + " "); //BLUE
                zapis.write("\n");
            }
            zapis.write("\n");
        }

        //Vynut zapsani dat do souboru
        zapis.flush();
        //Uzavri soubor
        zapis.close();
    }
}