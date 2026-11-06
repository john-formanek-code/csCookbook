import java.util.Scanner;

public class Zakladniuhel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Zadej úhel ve stupních:");
        int uhel = sc.nextInt();


        while (uhel < 0) {
            uhel += 360;
        }


        while (uhel >= 360) {
            uhel -= 360;
        }

 
        System.out.println("Základní úhel je: " + uhel);

        sc.close();
    }
}
