public class Ukol3 {
    public static void main(String[] args) {
        String input = args.length > 0 ? args[0] : "AHOJ"; // když nic nepřijde, použiju default
        String[] map = {
            // T9 tabulka pro A-Z
            "2", "22", "222",
            "3", "33", "333",
            "4", "44", "444",
            "5", "55", "555",
            "6", "66", "666",
            "7", "77", "777", "7777",
            "8", "88", "888",
            "9", "99", "999", "9999"
        };

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < 'A' || c > 'Z') {
                // rychlá pojistka na vstup
                throw new IllegalArgumentException("Only A-Z uppercase");
            }
            out.append(map[c - 'A']);
        }
        System.out.println(out.toString());
    }
}
