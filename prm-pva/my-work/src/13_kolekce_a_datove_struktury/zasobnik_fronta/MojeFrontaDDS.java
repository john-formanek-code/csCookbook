package Stack;

public class MojeFrontaDDS {
    private Node qIn;
    private Node qOut;

    public MojeFrontaDDS() {
        this.qIn = null;
        this.qOut = null;
    }

    public boolean isEmpty() {
        return this.qIn == null; // Only chech one, doesnt need to check everything
    }

    public void add(int a) {
        Node tmp = new Node(a);

        if (isEmpty()) {
            qOut = tmp;
        } else {
            qIn.setNext(tmp);
        }
        qIn = tmp;
    }

    public int remove() {
        Node tmp = qOut;
        if (isEmpty()) {
            throw new MojeVyjimkaException();
        }
        if (qIn == qOut) {
            qIn = null;
            qOut = null;
        } else {
            qOut = qOut.getNext();
        }
        return tmp.getValue();
    }

    public static void main(String[] args) {
        MojeFrontaDDS kybl = new MojeFrontaDDS();
        kybl.add(1);
        System.out.println(kybl.isEmpty());
        kybl.remove();
        System.out.println(kybl.isEmpty());
    }
}
