package Rectangle;
public class Main {
    public static void main(String[] args) {
        
        Draw_rectangle c = new Draw_rectangle(5, 10);
        System.out.println("Height: " + c.getHeight());
        System.out.println("Width: " + c.getWidth());
        System.out.println("Area: " + c.getArea());
        c.draw();

        Draw_rectangle d = new Draw_rectangle(76, 7);
        System.out.println("Height: " + d.getHeight());
        System.out.println("Width: " + d.getWidth());
        System.out.println("Area: " + d.getArea());
        d.draw();
    }
    
}
