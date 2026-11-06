package prvocislo;

public class Main {
    public static void main(String[] args) {

       // int size = 100_000;
       // int [] pole = new int [size];
        int n = 71827;
        boolean prime = true;
        for (int i = 2; i< n/2; i++){
            if(n%i ==0){
                return;
            }
        }


    }
    public static boolean isPrime(int n){
        int n = 71827;
        for (int i = 2; i< n/2; i++){
            if(n%i ==0){
                return false;
            }
        }
        
    }
}
