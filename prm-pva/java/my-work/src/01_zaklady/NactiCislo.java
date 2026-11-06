package IT;

import java.util.Scanner;

public class ctiint {
    public static void main(String[] args) {
        System.out.println("Napiš číslo:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println("Výsledek je:");
        System.out.println(a + 1);

        scan.close();
    }

}
