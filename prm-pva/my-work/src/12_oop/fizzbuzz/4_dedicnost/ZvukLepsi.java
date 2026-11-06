package fizzbuzzLepsi;

public class ZvukLepsi extends Zvuk{

    public ZvukLepsi(int cislo, String str) {
        super(cislo, str);

    }
    @Override
    public String dejZvuk(int a){
        if(a%cislo == 0){
            return String.format("%d=%d*%d %s", a, cislo, (a/cislo), super.dejZvuk(a));
        } else {
            return "";
        }
        
    }
    
}
