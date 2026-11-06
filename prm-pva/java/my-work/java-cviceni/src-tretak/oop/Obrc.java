package obrc;

import java.util.HashMap;
import java.util.Iterator;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Obrc {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("C:\\temp\\mer6.txt");
        BufferedReader br = new BufferedReader(fr);
        String radek;

        HashMap<String, City> mesto = new HashMap<>();   // ← sem!

        while ((radek = br.readLine()) != null) {
            String[] pole = radek.split(";");

            if (mesto.containsKey(pole[0])) {
                mesto.get(pole[0]).addTemperature(Double.parseDouble(pole[1]));
            } else {
                mesto.put(pole[0], new City(Double.parseDouble(pole[1])));
            }           
        }

        fr.close();

        Iterator<String> keySetIterator = mesto.keySet().iterator();

        while(keySetIterator.hasNext()){
            //String key = keySetIterator.next();
            //System.out.println("key: "+key + " value: " + mesto.get(key));
            //sj.add();
        }
    }
}
