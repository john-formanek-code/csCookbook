package cerven;

public class Posloupnosti {
    public static void main(String[] args) {
        int stary = 3;

        for (int i = 1; i <= 20; i++) {
            System.out.println(stary);
            stary = stary * (-2) + 3;
        }
    }
}
