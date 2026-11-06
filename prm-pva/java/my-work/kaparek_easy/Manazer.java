class Zamestnanec {
    private String jmeno;
    private int vek;
    private double plat;

    // jsem zvyklí používat encapsulaci

    public Zamestnanec(String jmeno, int vek, double plat) {
        this.jmeno = jmeno;
        this.vek = vek;
        this.plat = plat;
    }

    public void vypisInfo() {
        System.out.printf("Jméno: %s, Věk: %d, Plat: %.2f Kč%n", jmeno, vek, plat);
    }
}

public class Manazer extends Zamestnanec {
    private String oddeleni;

    public Manazer(String jmeno, int vek, double plat, String oddeleni) {
        super(jmeno, vek, plat);
        this.oddeleni = oddeleni;
    }

    @Override
    public void vypisInfo() {
        super.vypisInfo();
        System.out.printf("Oddělení: %s%n", oddeleni);
    }

    public static void main(String[] args) {
        Zamestnanec zamestanec = new Zamestnanec("Josef Svoboda", 40, 45000);
        Manazer manazer = new Manazer("Richard Svodobnik", 87, 80000, "IT");

        System.out.println("Zaměstnanec");
        zamestanec.vypisInfo();

        System.out.println("Manažer");
        manazer.vypisInfo();
    }
}
