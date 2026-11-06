package Stack;

public class Node {
    //@SuppressWarnings("unused")
    private final int value;
    private Node next;

    public Node(int vloz) {
        this.value = vloz;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [getValue()=" + getValue() + "]";
    }

    public static void main(String[] args) {
        Node n = new Node(6);
        System.out.println(n.toString());
    }
}
