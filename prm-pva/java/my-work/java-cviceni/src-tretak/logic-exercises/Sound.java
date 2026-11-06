package fizzbuzz;

public class Sound {
    int trigger;
    String ono;

    public Sound(int trigger, String ono) {
        this.trigger = trigger;
        this.ono = ono;
    }

    public String generate(int i) {
        if (i % trigger == 0) {
            return ono;
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        Sound pejsek = new Sound(6, "Haf");
        System.out.println(pejsek.generate(12));
        System.out.println(pejsek.generate(13));
        System.out.println(pejsek.generate(15));
    }

}
