package IT ;

import java.util.Scanner;

public class Cifry1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadej číslo: ");
        int cislo = sc.nextInt();  
        int sum = 0;

       
        while (cislo > 0) {
            sum += cislo % 10;  
            cislo = cislo / 10; 
        }

        System.out.println(sum);

        sc.close(); 
    }
}
