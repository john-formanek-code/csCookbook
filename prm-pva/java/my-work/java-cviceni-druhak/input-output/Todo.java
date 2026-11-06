import java.util.Scanner;
import java.util.ArrayList; 

public class Todo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Změněno jméno na scanner
        ArrayList<String> seznamUkolu = new ArrayList<>();  // Seznam pro ukládání úkolů
        
        System.out.println("To-do seznam");
        System.out.println("Zadej nový úkol:");

        while (true) {
            String novyUkol = scanner.nextLine();  // Přečte nový úkol

            if (novyUkol.equalsIgnoreCase("konec")) {
                System.out.println("Program je ukončen.");
                break;  // Ukončení cyklu
            }
            if(novyUkol.equalsIgnoreCase("smazat")){
                seznamUkolu.clear();
                continue;
            }
            // Uložení úkolu do seznamu
            seznamUkolu.add(novyUkol);
            System.out.println("Úkol byl přidán: " + novyUkol);
            
            // Vytiskne všechny úkoly
            System.out.println("Seznam úkolů:");
            for (String ukol : seznamUkolu) {
                System.out.println("- " + ukol);
            }

            

            System.out.println("\nZadej nový úkol (nebo 'konec' pro ukončení):");
        }

        scanner.close();
    }
}
