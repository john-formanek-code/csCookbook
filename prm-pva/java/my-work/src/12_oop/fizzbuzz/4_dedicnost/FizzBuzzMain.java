package fizzbuzzLepsi;

public class FizzBuzzMain {
    public static void main(String[] args) {
// Pole ktere naplnime zvuky a staci pridat dalsi pole
       Zvuk[] zvuky = {
                new Zvuk(3, "Fizz"),
                new ZvukLepsi(5, "Buzz"),
                new Zvuk(7, "Baxx"),
                new Zvuk(11, "Bzum"),
                new Zvuk(13, "Becherovka"),
                new Zvuk(17, "Vodka")
        };

       
// Globalni promena pro zadavani poctu cisel
        int global = 1000;

        for (int i = 1; i <= global; i++) {
            String dohromady = "";
            for (Zvuk z : zvuky) {
                dohromady +=  z.dejZvuk(i);
            }
            System.out.println(dohromady.length() == 0 ? i : dohromady);
        }
    }
}
