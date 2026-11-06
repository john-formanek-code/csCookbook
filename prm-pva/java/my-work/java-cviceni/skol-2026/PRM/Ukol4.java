public class Ukol4 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder(); // efektivnější
            for (int j = 0; j < 25; j++) {
                int number = (int) (Math.random() * 9) + 1;
                // bez nuly
                sb.append(number);
            }
            System.out.println(sb.toString());
        }
    }
}
