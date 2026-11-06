
import java.io.FileWriter;
import java.io.IOException;

public class Zapis2{
    public static void main(String[] args) throws IOException{
        FileWriter zapis = new FileWriter("out2.txt", false);

        for (int i = 0; i < 100; i++) {
            //Prevod cisla na retezec
            zapis.write(i + " ");

            if (i % 10 == 9) {
                zapis.write("\n");
            }
        }

        //Vynut zapsani dat do souboru
        zapis.flush();
        //Uzavri soubor
        zapis.close();
    }
}