import java.util.Scanner;

public class KvRovnice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadej první číslo:");
        int a = sc.nextInt();
        System.out.print("Zadej druhe číslo:");
        int b = sc.nextInt();
        System.out.print("Zadej treti číslo:");
        int c = sc.nextInt();

        int diskriminant = b*b-4*a*c;
System.out.println(a+"x^2+" + b + "x+" + c + "=0");
        if(diskriminant<0){
            System.out.println("---nema reseni");
            System.exit(0);
        }
        if(diskriminant==0){
            int x = -b/(2*a);
            System.out.println("---- x=" + x);
            System.exit(0);
        }

        double x1 = (- b +Math.sqrt(diskriminant)) / (2*a);
        double x2 = (- b -Math.sqrt(diskriminant)) / (2*a);
        System.out.println("---- x1=" + x1 + "----- x2=" +x2);

        sc.close();
    }

}
