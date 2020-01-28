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
    
    /**
     * constructor for first insert
     */
    public Shape(String name, int h, int w, int x, int y) {
        
        this.name = name;
        height = h;
        width = w;
        this.x = x;
        this.y = y;
        
    }
    
    //need compareTo and toString
}
