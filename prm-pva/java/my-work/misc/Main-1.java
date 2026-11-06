import java.io.FileWriter;
import java.io.IOException;

public class Main {

    //proste to cte tokeny ze standardniho vstupu a vypisuje na standardni vystup
    //tokeny jsou oddeleny libovolnym whitespaces
    static final class Token {
        private static final int BUF = 1 << 16; // 64kB buffer, to by melo stacit
        private static final byte[] b = new byte[BUF]; // buffer pro cteni ze vstupu
        private static int len = 0, pos = 0; // pozice v bufferu
        
        // cte jeden byte ze standardniho vstupu
        // vraci -1 na EOF
        private static int rd() throws IOException {
            if (pos >= len) {
                len = System.in.read(b);
                pos = 0;
                if (len <= 0) return -1;
            }
            return b[pos++] & 0xFF;
        }
        // vrati dalsi "slovo" oddelene whitespace, nebo null na EOF
        // pokud je jeste co cist, tak je to chyba
        static String next() throws IOException {
            StringBuilder s = new StringBuilder();
            int c; //c = charakter
            // přeskoč whitespace
            while (true) {
                c = rd();
                if (c == -1) return null;
                if (!Character.isWhitespace(c)) break;
            }
            // načte token
            do {
                s.append((char) c);
                c = rd();

            } while (c != -1 && !Character.isWhitespace(c));
            return s.toString();
        }

        // podívá se dopředu, zda zbyl nějaký ne-whitespace znak
        // vraci true/false
        static boolean hasMoreNonWs() throws IOException {
            System.in.mark(BUF); // zapamatuje si pozici
            int c; // 

            // podívá se dopředu, zda zbyl nějaký ne-whitespace znak
            while ((c = rd()) != -1) {
                if (!Character.isWhitespace(c)) { System.in.reset(); return true; }
            }
            System.in.reset();
            return false;
        }
    }
    
    // vypíše chybovou hlášku a ukončí program
    private static void bad() {
        System.out.println("wrong format");
        System.exit(0);
    }

    // hlavní program
    // čte ze standardního vstupu, píše na standardní výstup
    // vstup musí být přesně ve formátu P3
    // výstup bude přesně ve formátu P2
    // "špatný standart" a ukončí program
    public static void main(String[] args) throws IOException {
        // hlavicka P3
        String magic = Token.next();

        // kontrola magic number
        if (magic == null || !magic.equals("P3")) bad();

        String w = Token.next(), h = Token.next(), mv = Token.next();
        // kontrola, zda máme všechny 3 položky
        if (w == null || h == null || mv == null) bad();

        int sirka, vyska, MAX_VAL;

        // kontrola velikosti obrázku a maximální hodnoty
        try {
            sirka = Integer.parseInt(w);
            vyska = Integer.parseInt(h);
            MAX_VAL = Integer.parseInt(mv);
        } catch (NumberFormatException e) { bad(); return; }

        // musí být kladné
        if (sirka <= 0 || vyska <= 0 || MAX_VAL <= 0) bad();

        // zapis hlavicky P2 
        // (MAX_VAL zachován)
        try (FileWriter fw = new FileWriter("vystup_p2.ppm", false)) {
            fw.write("P2\n");
            fw.write(sirka + " " + vyska + "\n");
            fw.write(Integer.toString(MAX_VAL) + "\n");

            // presne sirka * vyska trojic (R, G, B)
            // prubezny prevod a zapis
            long totalPix = 1L * sirka * vyska;
            for (long p = 0; p < totalPix; p++) {

                String rs = Token.next(); if (rs == null) bad();
                String gs = Token.next(); if (gs == null) bad();
                String bs = Token.next(); if (bs == null) bad();

                int r, g, b;
                // kontrola rozsahu a prevod na int
                try {
                    r = Integer.parseInt(rs);
                    g = Integer.parseInt(gs);
                    b = Integer.parseInt(bs);
                } catch (NumberFormatException e) { bad(); return; }

                // musí být kladné a menší nebo rovno MAX_VAL
                if (r < 0 || r > MAX_VAL || g < 0 || g > MAX_VAL || b < 0 || b > MAX_VAL) bad();

                int gray = (int)Math.round(0.299 * r + 0.587 * g + 0.114 * b);

                // ořezání do rozsahu
                if (gray < 0) gray = 0;
                if (gray > MAX_VAL) gray = MAX_VAL;

                // formátování řádků stejně jako v tvých zápisech
                int x = (int)(p % sirka);
                if (x > 0) fw.write(' ');
                fw.write(Integer.toString(gray));
                if (x == sirka - 1) fw.write('\n');
            }
            // pokud je ještě co číst, tak je to chyba
            fw.flush();
        }

        // nesmí zůstat žádná další data (krom whitespace)
        if (Token.hasMoreNonWs()) bad();
    }
}
