public class StringExpander {
    static void consoleBomb(String s) {
        int level = 0;
        int zac = 0;

        for (int i = 0; i < s.length(); i++) {
            // je-li to znak
            if ((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z')) {
                if (level == 0) {
                    System.out.print(s.charAt(i));
                } else {

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
            }
        }
    }
}