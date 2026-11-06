package morseovka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Morse {
    static String[] mtab= new String[128];
    static HashMap<String, Character> rtab = new HashMap<>();

    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("H:\\PVA\\pokusy\\src\\morseovka\\morse.txt");
        BufferedReader br = new BufferedReader(fr);
        String radek;

        while((radek = br.readLine()) != null){
            System.out.printf(">%s<%n", radek);
        }

        fr.close();
    }
    static {
        mtab[0] = "?";
        for (int i=1; i<128; i++) mtab[i] = mtab[0];
        mtab['A'] = ".-";
        mtab['B'] = "-...";
        mtab['C'] = "-.-.";
        mtab['D'] = "-..";
        mtab['E'] = ".";
        mtab['F'] = "..-.";
        mtab['G'] = "--.";
        mtab['H'] = "....";
        mtab['I'] = "..";
        mtab['J'] = ".---";
        mtab['K'] = "-.-";
        mtab['L'] = ".-..";
        mtab['M'] = "--";
        mtab['N'] = "-.";
        mtab['O'] = "---";
        mtab['P'] = ".--.";
        mtab['Q'] = "--.-";
        mtab['R'] = ".-.";
        mtab['S'] = "...";
        mtab['T'] = "-";
        mtab['U'] = "..-";
        mtab['V'] = "...-";
        mtab['W'] = ".--";
        mtab['X'] = "-..-";
        mtab['Y'] = "-.--";
        mtab['Z'] = "--..";
        mtab['0'] = "-----";
        mtab['1'] = ".----";
        mtab['2'] = "..---";
        mtab['3'] = "...--";
        mtab['4'] = "....-";
        mtab['5'] = ".....";
        mtab['6'] = "-....";
        mtab['7'] = "--...";
        mtab['8'] = "---..";
        mtab['9'] = "----.";
        mtab[' '] = " ";
        for (int i='a'; i<='z'; i++) mtab[i] = mtab[i-32];
        
        for (int i=0; i<mtab.length; i++) {
            rtab.put(mtab[i], (char)i);
        }
    }
}
