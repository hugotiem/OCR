package tests;

import model.Parser;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

    private Parser parser = new Parser();

    @Test
    public void souldParseStringToNumber() throws Exception {
        String code = "000001001";
        int number = parser.parse(code);
        Assert.assertSame(1, number);
    }

    @Test
    public void shouldDecodeString() throws Exception {
        String code = "     |  |";
        String string = parser.decode(code);
        Assert.assertEquals("000001001", string);
    }

    @Test 
    public void shouldDecodeAndParseStringToNumber() throws Exception {
        String code = "     |  |";
        String string = parser.decode(code);
        int number = parser.parse(string);
        Assert.assertSame(1, number);
    }

    @Test
    public void checksumShouldReturnTrue() throws Exception, FileNotFoundException {

        ArrayList<Integer> tab = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            tab.add(i+1);
        }
        boolean result = parser.checksum(tab);
        Assert.assertEquals(true, result);
    }

    @Test
    public void checksumShouldNotReturnTrue() throws Exception, FileNotFoundException {

        ArrayList<Integer> tab = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            tab.add(i+2);
        }
        boolean result = parser.checksum(tab);
        Assert.assertEquals(false, result);
    }
}