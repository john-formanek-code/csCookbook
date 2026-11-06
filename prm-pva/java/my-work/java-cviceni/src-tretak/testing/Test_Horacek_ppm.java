package ppm;
import java.io.*;
import java.util.*;

public class Test_Horacek {
    public static void main(String[] args) throws IOException {
        //Soubor, který načítáme
        Scanner sc = new Scanner(new File("incomplete-data_p3.ppm"));
        // Soubor, který vytváříme
        PrintWriter pw = new PrintWriter("vysledek.ppm");


        if (!sc.hasNextLine()) {
                System.out.println("ŠPATNÝ STANDART");
                sc.close();
                pw.close();
                return;
            }
        // Pokud je formát jiný než P3 korektně ukončí program
        String format = sc.nextLine().trim();
        if (!format.equals("P3")) {
            System.out.println("ŠPATNÝ STANDART");
            sc.close();
            pw.close();
            return;
        }

        // Načte rozměry obrázku
        int width = sc.nextInt();
        int height = sc.nextInt();

        // Načti maximálni hodnotu
        int maxVal = sc.nextInt();

        // Zapiše hlavičku P2
        pw.println("P2");
        // Zapíše načtené rozměry
        pw.println(width + " " + height);
        // Zapíše načtenou hodnotu
        pw.println(maxVal);

        //Ověříme kolik hodnot máme a rozhodneme jestli není špatný standart
        int pocetHodnot = width * height * 3;
        int pocetNactenych = 0;

        // Převedeme na šedou 
        while (sc.hasNextInt()) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();

            int gray = (int)(0.299 * r + 0.587 * g + 0.114 * b);
            pw.println(gray);

            pocetNactenych += 3;
        }

        // Ověření počtu dat, pokud se nerovnají je špatný standart
        if (pocetNactenych != pocetHodnot) {
            System.out.println("ŠPATNÝ STANDART");
        } else {
            System.out.println("Hotovo. Soubor vystup.ppm vytvořen.");
        }

        sc.close();
        pw.close();
    }
}
