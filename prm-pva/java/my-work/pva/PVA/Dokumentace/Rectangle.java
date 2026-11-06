package Dokumentace;
/**
 * Třída Rectangle reprezentuje obdélník se zadanou výškou a šířkou.
 * Poskytuje metody pro výpočet plochy a pro vykreslení obdélníku
 * do konzole pomocí zvoleného znaku.
 */
public class Rectangle {
    private int height;
    private int width;
    private char symbol;

    /**
     * Vytvoří nový obdélník.
     *
     * @param height výška obdélníku (kladné celé číslo)
     * @param width  šířka obdélníku (kladné celé číslo)
     * @param symbol znak, kterým se obdélník vykreslí
     * @throws IllegalArgumentException pokud je výška nebo šířka neplatná
     */
    public Rectangle(int height, int width, char symbol) {
        setHeight(height);
        setWidth(width);
        this.symbol = symbol;
    }

    /**
     * Vrací výšku obdélníku.
     * @return výška obdélníku
     */
    public int getHeight() {
        return height;
    }

    /**
     * Vrací šířku obdélníku.
     * @return šířka obdélníku
     */
    public int getWidth() {
        return width;
    }

    /**
     * Nastaví výšku obdélníku.
     * @param height nová výška (> 0)
     * @throws IllegalArgumentException pokud je hodnota neplatná
     */
    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Výška musí být > 0");
        }
        this.height = height;
    }

    /**
     * Nastaví šířku obdélníku.
     * @param width nová šířka (> 0)
     * @throws IllegalArgumentException pokud je hodnota neplatná
     */
    public void setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Šířka musí být > 0");
        }
        this.width = width;
    }

    /**
     * Vrací plochu obdélníku.
     * @return plocha obdélníku
     */
    public int getArea() {
        return height * width;
    }

    /**
     * Vykreslí obdélník do konzole.
     */
    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}
