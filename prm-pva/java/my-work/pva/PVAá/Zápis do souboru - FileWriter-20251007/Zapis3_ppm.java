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
        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                //Zapis hodnoty pixelu
                if ((x + y) % 2 == 0) {
                    zapis.write("1 ");
                } else {
                    zapis.write("0 ");
                }
            }
            zapis.write("\n");

        }

        //Vynut zapsani dat do souboru
        zapis.flush();
        //Uzavri soubor
        zapis.close();
    }
}