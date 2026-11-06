package obrc;

import java.util.Locale;

/**
 * Třída slouží v projektu k reprezentaci dat o městu. Eviduje min teplotu, průměr a max teplotu.
 * @author Horáček René
 * @version 1.0
 */
public class City {
    double minT;
    double maxT;
    double sumT;
    int kolik;

/**
 * Konstruktor tralalero tralala
 * 
 * @param t
 */

    public City(double t){
        kolik = 1;
        minT = maxT = sumT = t;
    }
/**
 * Hululala
 * 
 * @return vrátí minimální hodnotu
 */
    public double getMinT() {
        return minT;
    }

    public double getMaxT() {
        return maxT;
    }
    
    public double getAvg(){
        return sumT/kolik;
    }
    
    public void addTemperature(double t){
        kolik++;
        sumT += t;
        if(t<minT){
            minT=t;
        }
        if(t>maxT){
        maxT=t;
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%1.1f/%1.1f/%1.1f", getMinT(), getAvg(), getMaxT());
    }

    public static void main(String[] args) {
        City jihlava = new City(6.7);

        jihlava.addTemperature(0);
        jihlava.addTemperature(-6.7);
        jihlava.addTemperature(8.3);

        System.out.println(jihlava.toString());
    }
}
