package ppm;
import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("vstup.ppm"));
        PrintWriter writer = new PrintWriter("vystup.ppm");

        // Přeskočíme první řádek (P3)
        scanner.nextLine();

        // Přečteme řádky až na rozměry
        String line = scanner.nextLine().trim();

        // Přeskočíme komentáře před rozměry
        while (line.startsWith("#") || line.isEmpty()) {
            line = scanner.nextLine().trim();
        }

        String[] dimensions = line.split("\\s+");
        int width = Integer.parseInt(dimensions[0]);
        int height = Integer.parseInt(dimensions[1]);

        // Stejně i max hodnotu (přeskočíme komentáře)
        line = scanner.nextLine().trim();
        while (line.startsWith("#") || line.isEmpty()) {
            line = scanner.nextLine().trim();
        }
        int maxVal = Integer.parseInt(line);

        writer.println("P3");
        writer.println(width + " " + height);
        writer.println(maxVal);

        // Načteme všechna RGB čísla přes skip komentáře
        List<Integer> pixels = new ArrayList<>();
        while (scanner.hasNextLine()) {
            line = scanner.nextLine().trim();
            if (line.isEmpty() || line.startsWith("#")) continue;

            String[] parts = line.split("\\s+");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    pixels.add(Integer.parseInt(part));
                }
            }
        }

        // Zpracuj pixely po 3 (r,g,b)
        for (int i = 0; i < pixels.size(); i += 3) {
            int r = pixels.get(i);
            int g = pixels.get(i + 1);
            int b = pixels.get(i + 2);

            int gray = (r + g + b) / 3;  // nebo vážený průměr

            writer.println(gray + " " + gray + " " + gray);
        }

        scanner.close();
        writer.close();

        System.out.println("Hotovo. Soubor vystup.ppm vytvořen.");
    }
}
