package ppm;
import java.io.FileWriter;
import java.io.IOException;

public class Zapis3_ppm {
    public static void main(String[] args) throws IOException{
        FileWriter zapis = new FileWriter("obrazek1.ppm", false);

        int sirka = 5;
        int vyska = 5;

        //Hlavickla P1-P3
        zapis.write("P1\n");
        //Rozliseni
        zapis.write( sirka + " " + vyska + "\n");
        //Maximalni hodnota
        //

        for(int i=0; i< vyska; i++){
            for(int j=0; j< sirka; j++){
                zapis.write((j % 2) + " ");
            }
            zapis.write("\n");
        }






        
        zapis.flush();
        zapis.close();
    }
}