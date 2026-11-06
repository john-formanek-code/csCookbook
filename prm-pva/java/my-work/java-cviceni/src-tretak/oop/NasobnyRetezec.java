package rijen.prm;

public class NasobnyRetezec {
    int kolik;
    String s;

    public NasobnyRetezec(int kolik, String s) {
        this.kolik = kolik;
        this.s = s;
    }

    @Override
    public String toString() {
        return kolik + "x" + s;
    }

    public void vytiskni() {
        for (int i = 0; i < kolik; i++) {
            System.out.print(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NasobnyRetezec nr1 = new NasobnyRetezec(3, "Ahoj");
        
        System.out.println("Retezec: " + nr1);
        
        System.out.print("Vytiskne: ");
        nr1.vytiskni();
    }
}
