package fizzbuzzLepsi;

public class Zvuk {
    int cislo;
    String str;
    static int kolik = 0;
// Vygenerovany konstruktor
    public Zvuk(int cislo, String str) {
        this.cislo = cislo;
        this.str = str;
    }

    public String dejZvuk(int a) {
        return (a % cislo == 0 ? str : "");
    }

    public static int dejKolik(){
        return kolik;
        

    }

    /*
     * public static void main(String[] args){
     * Zvuk auticko = new Zvuk(9,"Brmbrm");
     * 
     * for(int i=0;i<100; i++){
     * System.out.println(i + auticko.dejZvuk(i));
     * }
     * }
     */

}
