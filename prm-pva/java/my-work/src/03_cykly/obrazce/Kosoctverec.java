public class Koso {
    public static void main(String[] args) {
        final int ZLEVA = 10;
        // 1.faze - rozsireni
        for (int i = 1; i <= 5; i++) {

            // odsazeni
            for (int k=1; k<=(5-i)+ZLEVA; k++) {System.out.print(" ");}
            
            // hvezdy
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2.faze - zuzeni
        for (int i=4; i>=1; i--){
             // odsazeni
             for (int k=1; k<=(5-i)+ZLEVA; k++) {System.out.print(" ");}
            
             // hvezdy
             for (int j = 1; j <= (2 * i - 1); j++) {
                 System.out.print("*");
             }
             System.out.println();
         }
 
        }
  
        

    }

