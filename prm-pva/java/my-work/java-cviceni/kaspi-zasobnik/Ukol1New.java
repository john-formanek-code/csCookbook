import java.util.Random;

public class Ukol1New {
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    // Jednoduchy zasobnik nad Node
    private static class Zasobnik {
        private Node top;
        private int size;

        void push(int value) {
            Node n = new Node(value);
            n.next = top;
            top = n;
            size++;
        }

        int pop() {
            int value = top.value;
            top = top.next;
            size--;
            return value;
        }

        int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        Zasobnik zasobnik = new Zasobnik();

        // 1) Vygeneruj 100 cisel a vloz je na zasobnik
        for (int i = 0; i < 100; i++) {
            int cislo = rnd.nextInt(10001) - 5000;
            zasobnik.push(cislo);
        }

        // 2) Ber vzdy 2 cisla, secti je a vrat vysledek zpet
        while (zasobnik.size() > 1) {
            int a = zasobnik.pop();
            int b = zasobnik.pop();
            zasobnik.push(a + b);
        }

        // 3) Posledni cislo je celkovy soucet; popem bude zasobnik prazdny
        int celkovySoucet = zasobnik.pop();
        System.out.println("Celkovy soucet: " + celkovySoucet);
    }
}
