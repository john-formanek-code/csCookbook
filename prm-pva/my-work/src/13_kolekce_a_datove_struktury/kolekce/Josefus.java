import java.util.ArrayList;

public class Josefus {

    // 🔵 Globální proměnné
    static int n = 13;   // počet lidí
    static int k = 4;   // krok (ob kolik obcházím)

    public static void main(String[] args) {
        System.out.println("Přeživší: " + josephus());
    }

    public static int josephus() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;

        while (list.size() > 1) {
            index = (index + k - 1) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }
}
