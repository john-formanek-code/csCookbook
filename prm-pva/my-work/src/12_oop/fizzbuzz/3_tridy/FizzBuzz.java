package fizzbuzz;

public class FizzBuzz {
    public static void main(String[] args) {
        Sound[] zvuk = { new Sound(3, "Fizz"),
                new Sound(5, "Buzz"),
                new Sound(7, "Baxx")
        };

        for (int i = 1; i < 100; i++) {
            String vystup = "";

            for (Sound s : zvuk) {
                vystup = vystup + s.generate(i);
            }

            if (vystup.equals("")){
                System.out.println(i);
            } else {
                System.out.println(vystup);
            }
        }

    }
}
