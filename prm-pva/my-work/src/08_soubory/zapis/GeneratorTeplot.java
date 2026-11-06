import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class Prikladdva {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        FileWriter fw = new FileWriter("sydney.txt");

        for (int i = 0; i < 100; i++) { //cyklus aby se vygenerovalo 100 měření
            double temp = 5 + (45 - 5) * random.nextDouble();
            String tempFormat = String.format(Locale.US, "%.1f", temp).replace('.', ','); // změna formátu aby tam nebyla tečka ale čárka
            
            fw.write("Sydney;" + tempFormat + "\n");
        }
        fw.close();
    }
}
