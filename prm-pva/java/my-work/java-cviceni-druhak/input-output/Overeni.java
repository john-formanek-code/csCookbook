package duben;

public class Overeni {
        public static void main(String[] args) {
            int cislo = 1997;
    
            if (jePrvocislo(cislo)) {
                System.out.println("Číslo " + cislo + " je prvočíslo.");
            } else {
                System.out.println("Číslo " + cislo + " není prvočíslo.");
            }
        }
    
        // Pomocná metoda pro ověření, zda je číslo prvočíslo
        public static boolean jePrvocislo(int n) {
            if (n < 2) return false;
    
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }
    

