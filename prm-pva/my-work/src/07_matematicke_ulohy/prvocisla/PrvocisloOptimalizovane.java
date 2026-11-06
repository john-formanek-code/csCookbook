package prvocislo;

import java.util.Scanner;

public class Prime {
    public static boolean isPrime(int nuber){
        if(nuber == 1) return false;
        if(nuber == 0) return false;
        if (nuber == 2) return true;
        if (nuber % 2 == 0) return false;

        for(int i = 3; i <= Math.sqrt(nuber); i+=2){
            if(nuber % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadej číslo pro ověření: ");
        final int prime = sc.nextInt();

        if(isPrime(prime) == false){
            System.out.print("Číslo: " + prime + " není prvočíslo");
        } else {
            System.out.print("Číslo: " + prime + " je prvočíslo");
        }
    
        sc.close();
    }
}