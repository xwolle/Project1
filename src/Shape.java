/**
 * Will contain all attributes of any object added
 * @author xander <xander1>
 * @version <1.28.20>
 *
 */
public class Shape {

    /**
     * instance fields
     * 
     * height, width, coordinates, and name
     * 
     */
    private int height;
    private int width;
    private int x;
    private int y;
    private String name;
    private String test;
    
    /**
     * constructor for shape
     */
    public Shape(String name, int h, int w, int x, int y) {
        
        this.name = name;
        height = h;
        width = w;
        this.x = x;
        this.y = y;
        this.test = "TESTING";
        
    }
    
    /**
     * name getter
     * @return name/keyval of object
     */
    public String getName() {
        
        return this.name;
        
    }
    /**
     * height getter
     * @return height
     */
    public int getHeight() {
        
        return this.height;
    }
    
    /**
     * width getter
     * @return width
     */
    public int getWidth() {
        
        return this.width;
    }
    /**
     * getter for X-POS
     * @return x-position
     */
    public int getXVal() {
        
        return this.x;
    }
    /**
     * getter for Y-POS
     * @return y-position
     */
    public int getYVal() {
        
        return this.y;
    }
    
    /**
     * return string representation of a shape
     */
    public String toString() {
        
        return ("(" + this.name + ", " + this.x + ", "
            + this.y + ", " + this.width + ", " + this.height + ")");
        
        
    }
    
    //need toString
}
