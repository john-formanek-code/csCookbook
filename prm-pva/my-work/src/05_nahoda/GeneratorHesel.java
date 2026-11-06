import java.util.Random;

public class Priklad {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 100; i++) { //100x se zopakuje cyklus pro 100 hesel
            StringBuilder password = new StringBuilder();
            for (int j = 0; j < 25; j++) { // hesla mají 25 písmen
                password.append(random.nextInt(9) + 1); //rozsah od 1 - 9
            }
            System.out.println(password);
        }
    }
}
