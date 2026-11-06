import java.util.Scanner;

public class Priklad1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadej číslo:");
        int a = sc.nextInt();

        while (a != 1) {
            if (((a % 2) == 1)) {
                a= a*3+1;
                System.out.println(a);

            } else {
                a= a/2;
                System.out.println(a);
            }
            sc.close();
        }
    }

}