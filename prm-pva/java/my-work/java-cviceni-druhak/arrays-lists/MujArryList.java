import java.util.ArrayList;
import java.util.Random;

public class MujArryList {
    public static void main(String[] args) {
        ArrayList<Integer> dpole = new ArrayList<>();
        Random rnd = new Random(4);

        for (int i = 1; i <= 10000; i++) {
            dpole.add(rnd.nextInt(i));
        }
// upravenej qucksort s arraylistem
        for (int i = 0; i < dpole.size() - 1; i++) {
            for (int j = 0; j < dpole.size() - i - 1; j++) {
                if (dpole.get(j) > dpole.get(j + 1)) {
                    int temp = dpole.get(j);
                    dpole.set(j, dpole.get(j + 1));
                    dpole.set(j + 1, temp);
                }
            }
        }

        for (int k = 0; k < 20; k++) {
            System.out.print(dpole.get(k) + " ");
        }
    }
}
