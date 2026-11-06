package ppm;
import java.io.FileWriter;
import java.io.IOException;

public class Zapis4_ppm {
    public static void main(String[] args) throws IOException{
        FileWriter zapis = new FileWriter("obrazek1.ppm", false);

        int sirka = 8;
        int vyska = 8;

        //Hlavickla P1-P3
        zapis.write("P2\n");
        //Rozliseni
        zapis.write( sirka + " " + vyska + "\n");
        //Maximalni hodnota
        zapis.write((sirka * vyska) + "\n");


        for(int i=0; i< vyska; i++){
            for(int j=0; j< sirka; j++){
                zapis.write((i*j) + " ");
            }
            zapis.write("\n");
        }






        
        zapis.flush();
        zapis.close();
    }
}