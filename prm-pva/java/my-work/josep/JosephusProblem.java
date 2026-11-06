import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class JosephusProblem {

    public static int josephus(int n, int k) {
        Queue<Integer> people = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        while (people.size() > 1) {

            // k - 1 lidí přesuneme na konec fronty
            for (int i = 1; i < k; i++) {
                people.add(people.remove());
            }

            // k-tého člověka vyřadíme
            int eliminated = people.remove();
            System.out.println("Vyřazen: " + eliminated);
        }

        return people.remove();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zadej počet lidí: ");
        int n = scanner.nextInt();

        System.out.print("Zadej krok vyřazování: ");
        int k = scanner.nextInt();

        int survivor = josephus(n, k);

        System.out.println("Přežije člověk číslo: " + survivor);

        scanner.close();
    }
}