import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class Ukol1 {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        boolean[] used = new boolean[401]; // hlídám unikátní 5.0..45.0 po desetinách
        int count = 0;
        try (BufferedWriter w = new BufferedWriter(new FileWriter("output1.txt"))) {
            while (count < 100) {
                int v = random.nextInt(401) + 50; // pracuju v desetinách (*10)
                if (!used[v - 50]) {
                    used[v - 50] = true;
                    w.write("Sydney," + format(v));
                    w.newLine();
                    count++;
                }
            }
        }
    }

    private static String format(int v) {
        int abs = Math.abs(v);
        int whole = abs / 10;
        int frac = abs % 10;
        return (v < 0 ? "-" : "") + whole + "," + frac;
    }
}
