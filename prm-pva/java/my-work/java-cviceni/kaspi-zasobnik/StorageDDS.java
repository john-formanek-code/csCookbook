

import java.util.Arrays;
import java.util.Random;

public class StorageDDS {
    private static class Node {
        private final int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node top;
    private int size;

    public StorageDDS() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void push(int value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
        size++;
    }

    public int pop() {
        int value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    private static void ukol1() {
        Random rnd = new Random();
        StorageDDS zasobnik = new StorageDDS();

        for (int i = 0; i < 100; i++) {
            int cislo = rnd.nextInt(10001) - 5000;
            zasobnik.push(cislo);
        }

        while (zasobnik.size() > 1) {
            int a = zasobnik.pop();
            int b = zasobnik.pop();
            int soucet = a + b;
            zasobnik.push(soucet);
        }

        System.out.println("1) Vysledne cislo v zasobniku: " + zasobnik.pop());
    }

    private static void ukol2() {
        Random rnd = new Random();
        int[] pole = new int[100];

        for (int i = 0; i < pole.length; i++) {
            pole[i] = rnd.nextInt(10001) - 5000;
        }

        int[] serazene = Arrays.copyOf(pole, pole.length);
        Arrays.sort(serazene);

        int tretiNejvetsi = serazene[serazene.length - 3];
        int pocet = 0;
        for (int cislo : pole) {
            if (cislo == tretiNejvetsi) {
                pocet++;
            }
        }

        System.out.println("2) 3. nejvetsi cislo je: " + tretiNejvetsi);
        System.out.println("   Pocet vyskytu v poli: " + pocet);
    }

    public static void main(String[] args) {
        ukol1();
        ukol2();
    }
}
