package rijen.prm;

public class Zamestnanec {
    String jmeno;
    int vek;
    double plat;

    public Zamestnanec(String jmeno, int vek, double plat) {
        this.jmeno = jmeno;
        this.vek = vek;
        this.plat = plat;
    }

    public void vypisInfo() {
        System.out.println("Jméno: " + jmeno);
        System.out.println("Věk: " + vek);
        System.out.println("Plat: " + plat + " Kč");
    }
}
