import java.util.Random;   // Kvůli generování náhodných čísel

public class jedna {

    // Node = jeden prvek v zásobníku
    // Ukládá hodnotu a odkaz na další prvek pod ním
    private static class Node {
        int value;   // uložené číslo
        Node next;   // odkaz na další uzel

        // Konstruktor - vytvoří nový uzel s danou hodnotou
        Node(int value) {
            this.value = value;
        }
    }

    // Vlastní implementace zásobníku (stack)
    // Funguje stylem LIFO = Last In, First Out
    // Poslední vložený prvek jde ven jako první
    private static class Zasobnik {
        private Node top;   // vrchol zásobníku
        private int size;   // počet prvků v zásobníku

        // Přidání prvku na vrchol zásobníku
        void push(int value) {
            Node n = new Node(value); // vytvoří nový uzel
            n.next = top;             // nový uzel ukazuje na starý vrchol
            top = n;                  // nový uzel se stane vrcholem
            size++;                   // zvýšení počtu prvků
        }

        // Odebrání prvku z vrcholu zásobníku
        int pop() {
            int value = top.value; // uložíme si hodnotu vrcholu
            top = top.next;        // posuneme vrchol o jeden níž
            size--;                // snížení počtu prvků
            return value;          // vrátíme odebranou hodnotu
        }

        // Vrátí aktuální počet prvků v zásobníku
        int size() {
            return size;
        }
    }

    public static void main(String[] args) {

        // Generátor náhodných čísel
        Random rnd = new Random();

        // Vytvoření prázdného zásobníku
        Zasobnik zasobnik = new Zasobnik();

        // Vložíme do zásobníku 100 náhodných čísel
        // v rozsahu -5000 až 5000
        for (int i = 0; i < 100; i++) {
            int cislo = rnd.nextInt(10001) - 5000;
            zasobnik.push(cislo);
        }

        // Dokud jsou v zásobníku alespoň 2 čísla,
        // vždy odebereme 2 horní čísla, sečteme je
        // a výsledek vrátíme zpět na zásobník
        while (zasobnik.size() > 1) {
            int a = zasobnik.pop();     // první horní číslo
            int b = zasobnik.pop();     // druhé horní číslo
            zasobnik.push(a + b);       // součet vrátíme zpět
        }

        // Na konci zůstane v zásobníku právě jedno číslo
        // To je výsledný součet všech původních čísel
        System.out.println("Vysledne cislo: " + zasobnik.pop());
    }
}