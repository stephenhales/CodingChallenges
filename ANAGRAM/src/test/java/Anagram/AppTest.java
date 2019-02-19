package Anagram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{

    public void testPalindrome()
    {
        assertTrue( App.checkPalindrome("ana") );
        assertTrue( App.checkPalindrome("anna") );
    }
}
