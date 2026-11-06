package Stack;
import java.util.Random;
import java.util.Stack;

public class test1 {
    public static void main(String[] args) {
        Stack<Integer> zasobnik = new Stack<>();
        Random rnd = new Random();

        //vygenerujeme 100 čísel,od nuly do 10_000 a díky -5000 posuneme roztmezí na od -5000 do 5000
        for (int i = 0; i < 100; i++) {
            int cislo = rnd.nextInt(10001) - 5000;
            zasobnik.push(cislo);
        }

        // dokud je velikost zásobníku větší než 1, vyhodíme dva čísla, sečteme je a výsledek dáme zpět.
        while (zasobnik.size() > 1) {
            int a = zasobnik.pop();
            int b = zasobnik.pop();
            int soucet = a + b;
            zasobnik.push(soucet);
        }

        // pak vypíšeme výsledek
        if (!zasobnik.isEmpty()) {
            System.out.println("Celkový součet: " + zasobnik.pop());
        }
    }
}
