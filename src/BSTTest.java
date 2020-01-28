

public class BSTTest extends student.TestCase {

    
    private BST<String> test;
    
    public void setUp() {
    
        test = new BST<String>();
        
    }
    
    //simple insert test with up to 3
    public void testInsert() {
        
        test.insert("xander");
        assertEquals("xander", test.toString());
        test.makeEmpty();
        
        test.insert("tom");
        test.insert("dick");
        test.insert("harry");
        
        assertEquals("tom", test.findMax());
        assertEquals("dick", test.findMin());
        
        test.remove("tom");
        assertEquals("harry", test.findMax());
        
    }
    
    public void testRemove() {
        
        test.insert("xander");
        assertFalse(test.isEmpty());
        
        test.remove("xander");
        assertTrue(test.isEmpty());
        
        test.insert("a");
        test.insert("b");
        test.insert("c");
        test.insert("d");
        test.insert("e");
        test.insert("f");
        test.insert("g");
        test.insert("h");
        test.insert("i");
        test.insert("j");
        
        test.remove("a");
        test.remove("b");
        test.remove("c");
        test.remove("d");
        test.remove("e");
        test.remove("f");
        test.remove("g");
        test.remove("h");
        test.remove("i");
        test.remove("j");
        
        assertTrue(test.isEmpty());
        
    }
    
    
}
