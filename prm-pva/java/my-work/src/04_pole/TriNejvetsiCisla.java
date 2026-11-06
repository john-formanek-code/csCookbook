package Stack;
import java.util.Random;

public class test2 {
    public static void main(String[] args) {
        int[] pole = new int[100];
        Random rnd = new Random();

        // opět generujeme čísla podle velikosti pole, v rozmezí -5000 do 5000
        for (int i = 0; i < pole.length; i++) {
            pole[i] = rnd.nextInt(10001) - 5000;
        }

        // vytvořil jsem tři instanční proměné
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;


        for (int cislo : pole) {
            if (cislo > max1) {
                max3 = max2;
                max2 = max1;
                max1 = cislo;
            } else if (cislo > max2) {
                max3 = max2;
                max2 = cislo;
            } else if (cislo > max3) {
                max3 = cislo;
            }
        }

        System.out.println("Největší: " + max1);
        System.out.println("Druhé největší: " + max2);
        System.out.println("Třetí největší: " + max3);
    }
}
