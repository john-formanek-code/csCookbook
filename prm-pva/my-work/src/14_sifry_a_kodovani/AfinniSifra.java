import java.io.*;

public class AfiniSifraGPT {

    static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ .,"; // 29 znaků
    static final int A = 15;
    static final int B = 22;
    static final int MOD = 29;

    public static void main(String[] args) {

        File vstup = new File("H:\\PVA\\pokusy\\src\\vstup.txt");
        File vystup = new File("H:\\PVA\\pokusy\\src\\vystup.txt");

        try (
            BufferedReader reader = new BufferedReader(new FileReader(vstup));
            BufferedWriter writer = new BufferedWriter(new FileWriter(vystup))
        ) {

            int c;

            while ((c = reader.read()) != -1) {

                char znak = (char) c;

                int index = ALPHABET.indexOf(znak);

                if (index != -1) {

                    int sifra = (A * index + B) % MOD;
                    char zasifrovany = ALPHABET.charAt(sifra);

                    writer.write(zasifrovany);

                } else {

                    // například nový řádek
                    writer.write(znak);
                }
            }

            System.out.println("Hotovo.");

        } catch (IOException e) {

            System.out.println("Chyba při práci se souborem.");
            e.printStackTrace();
        }
    }
}