package IT;

import javax.swing.*;

public class analog {

    public static void main(String[] args) {
        // Vytvoření okna
        JFrame frame = new JFrame("Největší číslo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.getContentPane().setBackground(java.awt.Color.LIGHT_GRAY);

        // Tři textová pole pro zadání čísel
        JTextField field1 = new JTextField(5);
        JTextField field2 = new JTextField(5);
        JTextField field3 = new JTextField(5);

        // Tlačítko pro výpočet
        JButton button = new JButton("Zjisti největší");

        // JLabel pro výsledek
        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setForeground(java.awt.Color.WHITE);  // Bílý text

        // Akce při stisknutí tlačítka
        button.addActionListener(e -> {
            try {
                // Přečte hodnoty z textových polí
                int a = Integer.parseInt(field1.getText());
                int b = Integer.parseInt(field2.getText());
                int c = Integer.parseInt(field3.getText());

                // Výpočet největšího čísla
                int max;
                if (a < b) {
                    if (b < c) {
                        max = c;
                    } else {
                        max = b;
                    }
                } else {
                    if (a < c) {
                        max = c;
                    } else {
                        max = a;
                    }
                }

                // Zobrazení výsledku
                resultLabel.setText("Největší číslo je: " + max);
            } catch (NumberFormatException ex) {
                // Chybová zpráva při neplatném vstupu
                resultLabel.setText("Zadej platná čísla!");
            }
        });

        // Rozložení komponent v okně
        frame.setLayout(new java.awt.FlowLayout());
        frame.add(new JLabel("První číslo:"));
        frame.add(field1);
        frame.add(new JLabel("Druhé číslo:"));
        frame.add(field2);
        frame.add(new JLabel("Třetí číslo:"));
        frame.add(field3);
        frame.add(button);
        frame.add(resultLabel);

        // Zobrazení okna
        frame.setVisible(true);
    }
}
