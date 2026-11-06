package prvocislo;

import java.util.StringJoiner;

/**
 * Trida {@code MalaNasobilka} vypisuje malou nasobilku (1–10)
 * ve forme prehledne tabulky do standardniho vystupu.
 *
 * <p>Kazdy radek odpovida jednomu cislu a obsahuje jeho nasobky
 * od 1 do 10.</p>
 *
 * @author Tve jmeno
 * @since 1.0
 */
public class MalaNasobilka {

    /**
     * Hlavni vstupni bod programu.
     *
     * <p>Metoda generuje tabulku nasobilky pomoci dvou vnorenych
     * cyklu {@code for}. Pro formatovani radku je pouzit
     * {@link StringJoiner}.</p>
     *
     * @param args argumenty prikazove radky (nepouzivaji se)
     */
    public static void main(String[] args) {
        /** Horni hranice nasobilky */
        final int END = 10;

        for (int i = 1; i <= END; i++) {
            StringJoiner sj = new StringJoiner(" |", "|", " |");

            for (int j = 1; j <= END; j++) {
                sj.add(String.format("%4d", i * j));
            }

            System.out.println(sj.toString());
        }
    }
}
