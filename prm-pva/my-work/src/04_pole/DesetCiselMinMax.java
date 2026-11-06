

import java.util.Scanner;

public class DesetCisel {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pole = new int[10];
        for (int i = 0; i < pole.length; i++) {
            System.out.print("Zadej " + (i + 1) + ". cislo: ");
            pole[i] = sc.nextInt();
        }

        for (int i = 0; i < pole.length; i++) {
            System.out.print(pole[i] + " ");
        }

        System.out.println("");

        for (int i = pole.length - 1; i >= 0; i--) {
            System.out.print(pole[i] + " ");
        }

        System.out.println("");

        int tmpMax = pole[0];
        for (int i = 1; i < pole.length; i++) {
            if (pole[i] > tmpMax) {
                tmpMax = pole[i];
            }
        }
        System.out.println(tmpMax); 

        int tmpMin = pole[0]; 
        for (int i = 1; i < pole.length; i++) {
            if (pole[i] < tmpMin) { 
                tmpMin = pole[i]; 
            }
        }
        System.out.println(tmpMin); 
         

        sc.close();
    }

}
