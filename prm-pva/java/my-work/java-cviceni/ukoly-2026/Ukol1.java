/*
vygenerujte 100 čísel v rozmezi -5000 až 5000 do zásobníku - náhodná čísla. 
odeberte prvni dve cisla -  sectete je a vysvedek vlozte na zasobnik - delejte to tak dlouho nez zbyde jedinné číslo
takze to bude nejaký while 
a vypiste 
*/

import java.util.Random;

public class Ukol1 {
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    //stack
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

        for (int i = 0; i < 100; i++) {
            int cislo = rnd.nextInt(10001) - 5000;
            zasobnik.push(cislo);
        }
        while (zasobnik.size() > 1) {
            int a = zasobnik.pop();
            int b = zasobnik.pop();
            zasobnik.push(a + b);
        }

        System.out.println("Vysledne cislo: " + zasobnik.pop());
    }
}
