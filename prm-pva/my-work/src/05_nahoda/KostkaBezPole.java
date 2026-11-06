

import java.util.Random;

public class naodnecislo {
    public static void main(String[]  args) {
    Random random = new Random();
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;                                                                                                                                                                                                                                                  
    for(int i =0; i<600; i++){
        int hod = random.nextInt(6) +1;

        if(hod == 1){
            a++;
        } 
        if(hod == 2){
            b++;
        } 
        if(hod == 3){
            c++;
        } 
        if(hod == 4){
            d++;
        } 
        if(hod == 5){
            e++;
        } 
        if(hod == 6){
            f++;
        } 
        
    }System.out.println("1 je: " + a);
        System.out.println("2 je: " +b);
        System.out.println("3 je: " +c);
        System.out.println("4 je: " +d);
        System.out.println("5 je: " +e);
        System.out.println("6 je: " +f);
        System.out.print("Dohromady je jich: ");
        System.out.print(a + b+ c+ d +e +f);
}
}
