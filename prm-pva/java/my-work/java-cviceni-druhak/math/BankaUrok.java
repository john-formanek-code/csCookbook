public class BankaUrok {
    public static void main(String[] args) {
        double zustatek = 10_000;
        int roky = 0;

        while (!(zustatek >= 1_234_567)){
            zustatek = zustatek +  zustatek * 0.025;
            roky++;
        }


        System.out.println(roky);
        System.out.println(zustatek);
    }
}
