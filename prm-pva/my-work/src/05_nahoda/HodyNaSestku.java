import java.util.Random;

public class Kolikhodu {
    public static void main(String[] args) {
        Random random = new Random();
        int hody = 0;
        int hod;

        do {
            hody = 0;
        do {
            hod = random.nextInt(6) + 1;
            hody++; 

        } while (hod != 6  );
        System.out.println("Padla 6 po " + hody + " hodech.");
    } while (hody<100);
    }
}
