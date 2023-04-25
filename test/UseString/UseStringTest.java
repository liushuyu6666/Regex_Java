package UseString;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UseStringTest {
    UseString useString;

    @Before
    public void setUp() {
        useString = new UseString();
    }

    @Test
    public void testGenerateInteger() {
        for(int i = 1; i < 100; i++) {
            useString.bind(UseString.StringFormat.INTEGER, i);
            String s = useString.getS();
            assertEquals("The length of string" + s + " should be " + i + ".", useString.getS().length(), i);
            assertTrue("The string" + s + " should be a number.", this.isInteger(s));
        }
    }

    @Test
    public void testGenerateDecimal() {
        for(int i = 2; i < 100; i++) {
            useString.bind(UseString.StringFormat.DECIMAL, i);
            String s = useString.getS();
            assertEquals("The length of string " + s + " should be " + i + ".", useString.getS().length(), i);
            assertTrue("The string " + s + " should be a number.", this.isDecimal(s));
        }
    }

    @Test
    public void testEscapeCharacter() {
        String pattern = "[0-9]*\\.[0-9]*";
        int i = 0;
        while(i++ < 2000) {
            useString.bind(UseString.StringFormat.DECIMAL, 20);
            String s = useString.getS();
            boolean res = s.matches(pattern);
            assertTrue("The string " + s + " should pass the match.", res);
        }
    }

    private boolean isInteger(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }
        return true;
    }

    private boolean isDecimal(String s) {
        boolean hasOneDot = false;
        char c;
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c < '0' || c > '9') {
                if(c == '.' && !hasOneDot) {
                    hasOneDot = true;
                } else {
                    return false;
                }
            }
        }
        return hasOneDot;
    }

}