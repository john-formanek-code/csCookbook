package ppm;
import java.io.FileWriter;
import java.io.IOException;

public class Zapis {
    public static void main(String[] args) throws IOException{
        FileWriter fw = new FileWriter("out.txt", false);

        int cislo = 20;

        fw.write("ahoj\n");
        fw.write("ahoj\n");
        fw.write("ahoj\n");
        fw.write(cislo + "\n");
        fw.write(Integer.toString(cislo));





        
        fw.flush();
        fw.close();
    }
}
