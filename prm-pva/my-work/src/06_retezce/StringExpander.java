public class StringExpander {

    static void consoleBomb(String s) {
        int level = 0;
        int zac, kon;

        for (int i = 0; i < s.length(); i++) {
            if (level == 0) {
                System.out.print(s.charAt(i));
            } else {

            }

            if ((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) {
                level++;
                if (level == 1) {
                    zac = i;
                }
            }
            if(s.charAt(i)==';'){
                level--;
                if(level == 0){
                    for(int j=0; i<(s.charAt(zac) - 48); i++){

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        consoleBomb("ABCBC;DRRRRRR;E");
    }
}