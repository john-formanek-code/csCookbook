public class Faktor {
    public static void main(String[] args) {

        int faktor = 10;
        int soucin = 1;
        int[] pole = new int[faktor];

        for (int i = faktor - 1; i >= 0; i--) {
            pole[i] = i + 1;
            soucin *= pole[i];
        }
        System.out.println(soucin);
    }

}
