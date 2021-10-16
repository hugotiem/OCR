package tests;

import model.Parser;
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
}