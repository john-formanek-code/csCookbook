package ppm;
import java.io.FileWriter;
import java.io.IOException;

public class Zapis2 {
    public static void main(String[] args) throws IOException{
        FileWriter zapis = new FileWriter("out2.txt", false);

        for(int i=0; i < 100; i++){
            zapis.write(i+" ");


            if( i % 10 == 0){
                zapis.write("\n");
            }
        }





        
        zapis.flush();
        zapis.close();
    }
}