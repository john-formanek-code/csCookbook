package cerven;

public class Narcis {
    public static void main(String[] args) {

        for (int i=1000; i<10000; i++){
            int soucet = 0;

            int a=i;
            while(a>0){
                int cifra = a % 10;
                soucet = soucet + cifra * cifra * cifra * cifra;
                a = a / 10;
            }

            if(soucet==i){
                System.out.println(i+ "je narcis");
            }
        }


    }
}
