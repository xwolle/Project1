import junit.framework.TestCase;

public class BSTTest extends TestCase {

    
    private BST<String> test;
    
    public void setUp() {
    
        test = new BST<String>();
        
    }
    
    //simple insert test
    public void testInsert() {
        
        test.insert("xander");
        assertEquals("xander", test.toString());
        test.makeEmpty();
        
        test.insert("tom");
        test.insert("dick");
        test.insert("harry");
        
    }
    
    
}
