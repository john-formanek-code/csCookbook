public class NasobnyRetezec {
    private int kolik;
    private String s;

    public NasobnyRetezec(int kolik, String s) {
        this.kolik = kolik;
        this.s = s;
    }

    @Override
    public String toString() {
        return kolik + "x" + s;
    }

    //String builder - mám ho radši než concatenate
    public void vytiskni() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < kolik; i++) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        NasobnyRetezec n1 = new NasobnyRetezec(3, "Ahoj");
        System.out.println(n1.toString());
        n1.vytiskni();

        NasobnyRetezec n2 = new NasobnyRetezec(5, "Hi");
        System.out.println(n2);
        n2.vytiskni();
    }
}
