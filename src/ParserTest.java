import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ParserTest extends student.TestCase {

    private Parser parse;
    private String[] tests;
    
    public void setUp() throws FileNotFoundException {
        
        String file1 = "insertTest1.txt";
        parse = new Parser(file1);
        
        
        
        
    }
    
    public void testParse() throws FileNotFoundException {
        
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outContent);
        System.setOut(ps);
    }
    
    
    
}
