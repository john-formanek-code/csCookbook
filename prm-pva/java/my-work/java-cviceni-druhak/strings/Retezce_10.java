

public class Retezce {
    public static void main(String[] args) {
        String text = "abcdefg";
        int delka = text.length();

        for (int i = 0; i < delka; i++) {
            text = text.charAt(delka - 1) + text.substring(0, delka - 1);
            System.out.println(text);
        }
    }
}


    

