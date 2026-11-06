package rijen;

public class Alg {
    static public boolean bruteforce(int[] data, int hledane) {
        boolean vysledek = false;
        int i = 0;
        for (i = 0; i < data.length; i++) {
            if (data[i] == hledane) {
                vysledek = true;

            }
        }
        System.out.println("Prohledano: " + i);
        return vysledek;
    }

    //////////////////////////////////////////////////////////////////////

    static public boolean bruteforce2(int[] data, int hledane) {
        boolean vysledek = false;
        int i = 0;
        for (i = 0; i < data.length; i++) {
            if (data[i] == hledane) {
                vysledek = true;
                break;

            }
        }
        System.out.println("Prohledano: " + i);
        return vysledek;
    }

    ///////////////////////////////////////////////////////////////////////

    public static boolean bezZarazky(int[] data, int hledane) {
        boolean vysledek = false;
        int i = 0;

        while (vysledek == false && i < data.length) {
            if (data[i] == hledane) {
                vysledek = true;

            }
            i++;
        }
        System.out.println("Prohledano:" + i);
        return vysledek;
    }

    ///////////////////////////////////////////////////////////////////

    public static boolean seZarazkou(int[] data, int hledane) {
        boolean vysledek = false;
        int i = 0;
        int[] novaData = new int[data.length + 1];

        for (i = 0; i < data.length; i++) {
            novaData[i] = data[i];
        }
        novaData[i] = hledane;
        i = 0;

        while (vysledek == false) {
            if (novaData[i] == hledane) {
                vysledek = true;
            }
            i++;
        }
        if(i == novaData.length){
            vysledek = false;
        }

        return vysledek;
    }

    ///////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        int[] data = { 1, 5, 3, 4, 2 };

        boolean vysledek = seZarazkou(data, 0);
        System.out.println("Hledane cislo nalezeno? " + vysledek);

        seZarazkou(data, 4);
        System.out.println("Hledane cislo bylo nalezeno? " + vysledek);
    }
}
