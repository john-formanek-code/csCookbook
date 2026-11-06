public class StringExpander {

    static void consoleBomb(String s) {
        int level = 0;
        int zac = -1, kon = -1;

        for (int i = 0; i < s.length(); i++) {

            // je-li to znak
            if ((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z')) {
                if (level == 0) {
                    System.out.print(s.charAt(i));
                }
            }

            // je-li to cislo
            if ((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) {
                level++;
                if (level == 1) {
                    zac = i;
                }
            }

            // je-li to ; strednik
            if (s.charAt(i) == ';') {
                level--;

                if (level == 0) {
                    kon = i;

                    for (int j = 0; j < (s.charAt(zac) - '0'); j++) {
                        consoleBomb(s.substring(zac + 1, kon));
                    }
                }
            }
        }
    }

    static String stringBomb(String s) {
        StringBuffer vysledek = new StringBuffer();

        int level = 0;
        int zac = -1, kon = -1;

        for (int i = 0; i < s.length(); i++) {

            // je-li to znak
            if ((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z')) {
                if (level == 0) {
                    vysledek.append(s.charAt(i));
                }
            }

            // je-li to cislo
            if ((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) {
                level++;
                if (level == 1) {
                    zac = i;
                }
            }

            // je-li to ; strednik
            if (s.charAt(i) == ';') {
                level--;

                if (level == 0) {
                    kon = i;

                    String cast = s.substring(zac + 1, kon);

                    for (int j = 0; j < (s.charAt(zac) - '0'); j++) {
                        vysledek.append(stringBomb(cast));
                    }
                }
            }
        }

        return vysledek.toString();
    }

public static void main(String[] args) {
    consoleBomb("A69A49A;;;;");

    System.out.println();

    String vysledek = stringBomb("A69A49A;;;;");
    System.out.println(vysledek.length()); // 1999
}
}