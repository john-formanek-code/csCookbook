package Rectangle;
public class Draw_rectangle {
    private int height;
    private int width;
    private static final int MAX_SIZE = 75;

    public Draw_rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }


    // Gettery
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    // Settery
    public void setHeight(int height) {
        if (height <=0 || height > MAX_SIZE){
            throw new IllegalArgumentException("Height must be between 1 and " + MAX_SIZE);
        }
        this.height = height;
    }

    public void setWidth(int width) {
        if (width <= 0 || width > MAX_SIZE) {
            throw new IllegalArgumentException("Width must be between 1 and " + MAX_SIZE);
        }
        this.width = width;
    }
    public int getArea() {
        return height * width;
    }
    public void draw(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }





    
    
}
