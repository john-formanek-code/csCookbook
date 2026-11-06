package Stack;

import java.util.Scanner;

public class MujZasobnikDDS {
    private Node vrchol;

    // Přidaný prázdný konstruktor
    public MujZasobnikDDS() {
        this.vrchol = null;
    }

    public boolean isEmpty() {
        return this.vrchol == null;
    }

    public void push(int dejToTam) {
        Node tmp = new Node(dejToTam);
        tmp.setNext(vrchol);
        vrchol = tmp;
    }

    public int pop() {
        Node tmp = vrchol;
        vrchol = vrchol.getNext();
        return tmp.getValue();
    }

    public int peek() {
        return vrchol.getValue();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MujZasobnikDDS z = new MujZasobnikDDS();

        System.out.println(z.isEmpty()); // true
        z.push(400);
        System.out.println(z.isEmpty());
        System.out.println(z.peek());

        for(int i=0; i< 5_000_000; i++){
            z.push(7*i);
        }
        //System.out.println(z.peek());
        while(!z.isEmpty()){
            z.pop();
        }
        //sc.nextLine();
    }
}