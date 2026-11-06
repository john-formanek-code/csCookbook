import java.util.Random;

public class RandomFizzBuzz {
    public static void main(String[] args) {
        // Vytvoření objektu pro generování náhodných čísel
        Random random = new Random();
        
        // Generování náhodných čísel 10krát (můžeš si změnit počet opakování)
        for (int i = 0; i < 10; i++) {
            // Generování náhodného čísla mezi 1 a 100
            int randomNumber = random.nextInt(100) + 1;

            // FizzBuzz podmínky
            if (randomNumber % 3 == 0 && randomNumber % 5 == 0) {
                System.out.println(randomNumber + ": FizzBuzz");
            } else if (randomNumber % 3 == 0) {
                System.out.println(randomNumber + ": Fizz");
            } else if (randomNumber % 5 == 0) {
                System.out.println(randomNumber + ": Buzz");
            } else {
                System.out.println(randomNumber + ": " + randomNumber);
            }
        }
    }
}
