public class Proklad3 {
    public static void main(String[] args) {
        System.out.println("1/7 na 500 míst:");

        int delenec = 1;
        int delitel = 7;
        System.out.print("0,");
        for (int i = 0; i < 500; i++) {
            delenec *= 10;
            System.out.print(delenec / delitel);
            delenec %= delitel;

            
        }

    }
}
