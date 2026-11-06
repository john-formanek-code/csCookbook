package cerven;

public class Zvykacky {
    public static void main(String[] args) { 
                int penize = 206;
        

                
                for (int zvykacky = 0; zvykacky <= penize / 5; zvykacky++) {
                    for (int housky = 0; housky <= penize / 11; housky++) {
                        int cena = zvykacky * 5 + housky * 11;
                        if (cena == penize) {
                            System.out.println("Žvýkaček: " + zvykacky + ", Housek: " + housky + " => Celkem: " + cena + " Kč");
                        }
                    }
                }
            }
        }

