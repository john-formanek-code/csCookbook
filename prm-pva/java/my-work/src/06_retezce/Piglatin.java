package cerven;
import java.util.Scanner;

public class Piglatin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadej slovo: ");
        String vstup = sc.next();  // načte jedno slovo 
        String vystup = "";

        vystup = vstup + vstup.substring(0,1);
        vystup = vystup.substring(1);
        vystup = vystup + "ay";


        System.out.println(vstup + " -> " + vystup);
        sc.close();
    }
}

