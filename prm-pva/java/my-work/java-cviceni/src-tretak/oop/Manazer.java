package rijen.prm;

public class Manazer extends Zamestnanec {
    String oddeleni;

    public Manazer(String jmeno, int vek, double plat, String oddeleni) {
            super(jmeno, vek, plat);
            this.oddeleni = oddeleni;
    }

    @Override
    public void vypisInfo() {
        super.vypisInfo();
        System.out.println("Oddělení: " + oddeleni);
    }

    public static void main(String[] args) {
        Zamestnanec z1 = new Zamestnanec("René Horáček", 18, 30000);
        System.out.println("Zaměstnanec:");
        z1.vypisInfo();

        System.out.println();

        Manazer m1 = new Manazer("Manazer Manazer", 40, 55000, "IT oddělení");
        System.out.println("Manažer:");
        m1.vypisInfo();
    }
}
