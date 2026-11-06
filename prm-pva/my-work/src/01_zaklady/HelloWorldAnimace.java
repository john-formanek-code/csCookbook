

public class Helloworld {

    public static void main(String[] args) {
        String text = "Hello World";
        
        // Pro zobrazení abecedy
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        // Spustíme vlákno pro abecedu
        for (char c : alphabet.toCharArray()) {
            
            try {
                Thread.sleep(100); // Pauza mezi znaky (100 ms)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println(); // Přejdeme na nový řádek
        
        // Zobrazení textu "Hello World" písmenko po písmenku
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(200); // Pauza mezi znaky (200 ms)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
 
