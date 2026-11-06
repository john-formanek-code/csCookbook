package duben;

public class Prvocisla {
        public static void main(String[] args) {
            System.out.println("Prvočísla od 1 do 100 jsou:");
    
            for (int cislo = 1; cislo <= 100; cislo++) {
                if (jePrvocislo(cislo)) {
                    System.out.print(cislo + " ");
                }
            }
        }
    
        // Pomocná metoda pro ověření, zda je číslo prvočíslo
        public static boolean jePrvocislo(int n) {
            if (n < 2) return false; // 1 není prvočíslo
    
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }
    

