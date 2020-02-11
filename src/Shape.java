/**
 * Will contain all attributes of any object added
 * @author xander <xander1>
 * @version <1.28.20>
 *
 */
public class Shape implements Comparable<Shape> {

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
    private String comp;
    
    /**
     * constructor for shape
     */
    public Shape(String name, int x, int y, int w, int h, String comp) {
        
        this.name = name;
        height = h;
        width = w;
        this.x = x;
        this.y = y;
        
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
    
    @Override
    public int compareTo(Shape other)
    {
        if (comp == "str")
        {
            return (this.name.compareTo(((Shape)other).getName()));
        }
        else
        {
            return (this.x*this.y*this.height*this.width - 
                ((Shape)other).getHeight()*((Shape)other).getWidth()
                *((Shape)other).getXVal()*((Shape)other).getYVal());
        }
    }

//    @Override
//    public int compareTo(Shape o) {
//        // TODO Auto-generated method stub
//        return 0;
//    }


}
