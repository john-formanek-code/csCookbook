public class Search {
    public static boolean bruteforce(int[] data, int hledane) {
        boolean vysledek = false;
        int i = 0;

        for(i = 0; i < data.length; i++) {
            if (data[i] == hledane) {
                vysledek = true;
            }
        }

        System.out.println("Prohledano :" + i);
        return vysledek;
    }

    public static boolean bruteforce2(int[] data, int hledane) {
        boolean vysledek = false;
        int i = 0;

        for(i = 0; i < data.length; i++) {
            if (data[i] == hledane) {
                vysledek = true;
                break;
            }
        }

        System.out.println("Prohledano :" + i);
        return vysledek;
    }

    public static boolean bezZarazky(int[] data, int hledane) {
        boolean vysledek = false;
        int i = 0;

        while((vysledek == false) && (i < data.length)) {
            if(data[i] == hledane) {
                vysledek = true;
            }

            i++;
        }

        System.out.println("Prohledano :" + i);
        return vysledek;
    }

    public static boolean seZarazkou(int[] data, int hledane) {
        boolean vysledek = false;
        int i = 0;
        int[] novaData = new int[data.length + 1];

        for(i = 0; i < data.length; i++) {
            novaData[i] = data[i];
        }

        novaData[i] = hledane;
        i = 0;

        while(vysledek == false) { 
            if(novaData[i] == hledane) {
                vysledek = true;
            }

            i++;
        }

        if(i == novaData.length) {
            vysledek = false;
        }

        return vysledek;
    }

    public static boolean binarySearch(int[] data, int hledane) {
        int left = 0;
        int right = data.length - 1;

        int middle;
        int steps = 1;

        do { 
            middle = (left + right) / 2;

            if (data[middle] == hledane) {
                System.out.println("Nalezeno po " + steps + " krocich");
                return true;
            }

            if (data[middle] > hledane) {
                //je v leve casti
                right = middle - 1;                
            } else {
                //je v prave casti
                left = middle + 1;
                
            }

            steps++;

        } while (left <= right);
        
        System.out.println("Nenalezeno po " + steps + " krocich");

        return false;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 5, 6, 7, 9};
        int i = 3;

        System.out.println("Hledane cislo " + i + " -> nalezeno: " + seZarazkou(data, i) + "\n\n");
        System.out.println("Hledane cislo " + i + " -> nalezeno: " + binarySearch(data, i) + "\n\n");
        
    } 
}