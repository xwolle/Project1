import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that handles all of the possible cases
 * from the input file
 * 
 * @author xander <xander1>
 * @version <1.28.20>
 *
 */
public class Parser extends BST {

    /**
     * fields
     */
    private BST shapesI;
    private BST shapesS;
    private Scanner fileInput;
    private Shape lastShape;
    
    
    /**
     * constructor
     */
    public Parser(String file) throws FileNotFoundException {
        
        shapesS = new BST();
        shapesI = new BST();
        fileInput = new Scanner(new File(file));
        lastShape = null;
        
        while (fileInput.hasNextLine()) {
            
            parseData();
        }
        
    }
    
    /**
     * parse data
     */
    public void parseData() {
        
        String next = fileInput.nextLine();
        
        if (!next.equals("")) {
            
            next = next.trim();
            String[] nextArr = next.split("\\s+");
            
            
            if (nextArr[0].equalsIgnoreCase("insert")) {
                
                if (Integer.parseInt(nextArr[4]) <= 0 || Integer.parseInt(nextArr[5]) <= 0
                    || (Integer.parseInt(nextArr[2]) <= 0) || (Integer.parseInt(nextArr[3]) <= 0)
                    || ((Integer.parseInt(nextArr[2]) + Integer.parseInt(nextArr[4]) > 1024))
                    || ((Integer.parseInt(nextArr[3]) + Integer.parseInt(nextArr[5]) > 1024))) {
                    
                    System.out.println("Rectangle rejected: (" + nextArr[1] + ", " + nextArr[2]
                        + ", " + nextArr[3] + ", " + nextArr[4] + ", " + nextArr[5] + ")");  
                    
                } else {
                    
                    lastShapeI = new Shape(nextArr[1], Integer.parseInt(nextArr[2]),
                        Integer.parseInt(nextArr[3]), Integer.parseInt(nextArr[4]),
                            Integer.parseInt(nextArr[5], "int"));
                    
                    lastShapeS = new Shape(nextArr[1], Integer.parseInt(nextArr[2]),
                        Integer.parseInt(nextArr[3]), Integer.parseInt(nextArr[4]),
                            Integer.parseInt(nextArr[5], "str"));
                    
                    shapesI.insert(lastShapeI)
                    shapesS.insert(lastShapeS)
                    
                    System.out.println("Rectangle accepted: " + lastShape.toString());
              
                    
                }
                
                
                
            }
            
            else if (nextArr[0].equalsIgnoreCase("remove"))
            {
                if (nextArr.length == 2)
                {
                    String name = nextArr[1];
                    Shape tempShape = new Shape (name,0,0,0,0,"str");
                    
                    if (shapesS.find(tempShape)  == null)
                    {
                        Systemp.out.println("SHAPE NOT FOUND");
                    }
                    else
                    {
                        Shape tempShape1 = new Shape(name, shapesS.find(tempShape).getHeight(), shapesS.find(tempShape).getWidth(), shapesS.find(tempShape).getXVal(), shapesS.find(tempShape).getYVal(), "int");
                        shapesI.remove(tempShape1);
                        shapesS.remove(tempShape);
                    }
                }
                else if (nextArr.length == 5)
                {
                    String h = nextArr[1];
                    String w = nextArr[2];
                    String x = nextArr[3];
                    String y = nextArr[4];
                    
                    Shape tempShape = new Shape ("frog",h,w,x,y,"int");
                        
                    if (shapesI.find(tempShape) == null)
                    {
                        Systemp.out.println("SHAPE NOT FOUND");
                    }
                    else
                    {
                        Shape tempShape1 = new Shape(shapesI.find(tempShape).getName()),0,0,0,0,"str");
                        shapesS.remove(tempShape1);
                        shapesI.remove(tempShape);
                    }
                }
            }
        }
    }   

}
