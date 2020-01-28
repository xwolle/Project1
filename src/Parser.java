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
    private BST shapes;
    private Scanner fileInput;
    private Shape lastShape;
    
    
    /**
     * constructor
     */
    public Parser(String file) throws FileNotFoundException {
        
        shapes = new BST();
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
                
                if (Integer.parseInt(nextArr[4]) <= 0 || Integer.parseInt(nextArr[5]) <= 0) {
                    
                    System.out.println("(Rectangle Rejected: " + nextArr[1] + ", " + nextArr[2]
                        + ", " + nextArr[3] + ", " + nextArr[4] + ")");  
                    
                }
                
                
            }
        }
    }
    

}
