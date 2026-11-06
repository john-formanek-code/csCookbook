package IT;

import java.util.Random;
public class Aray {

    public static void main(String[] args) throws Exception {
        Random rnd = new Random();
        int[] cis = new int[6];

        for(int i=0; i<600; i++) {
            int nahoda = rnd.nextInt(6);
            cis[nahoda]++;
        }
        for(int i = 0; i<6; i++){
            System.out.println((i+1) + " --> " + cis[i]);
        }
    }
}