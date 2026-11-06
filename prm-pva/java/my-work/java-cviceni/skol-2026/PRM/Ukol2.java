import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class Ukol2 {
    public static void main(String[] args) throws Exception {
        String[] cities = { "Atlanta", "Praha", "Nagano", "Dakar" };
        int[] min = { 50, -120, -200, 100 }; // hranice v desetinách (*10)
        int[] max = { 450, 350, 200, 500 };  // hranice v desetinách (*10)
        Random r = new Random();
        try (BufferedWriter w = new BufferedWriter(new FileWriter("output2.txt"))) {
            for (int i = 0; i < 1000; i++) {
                int idx = r.nextInt(cities.length);
                int v = r.nextInt(max[idx] - min[idx] + 1) + min[idx];
                w.write(cities[idx] + "," + format(v));
                w.newLine();
            }
        }
    }

    private static String format(int v) {
        int abs = Math.abs(v);
        int whole = abs / 10;
        int frac = abs % 10;
        // čárka místo tečky
        return (v < 0 ? "-" : "") + whole + "," + frac;
    }
}
