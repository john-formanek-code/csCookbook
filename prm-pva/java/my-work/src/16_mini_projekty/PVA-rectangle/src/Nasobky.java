public class Nasobky {
    private int n;

    public Nasobky(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public void printMultiples(){
        for (int i = 1; i <= n; i++) {
            System.out.println("Násobky čísla " + i + ":");
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
            System.out.println();
        }
        
    }
    
}
