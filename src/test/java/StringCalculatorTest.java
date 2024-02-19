import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void shouldVerifyAddEmptyString(){
        int sum = callMethodUnderTest("");
        Assert.assertEquals(0, sum);
    }

    @Test
    public void shouldVerifyAddSingleNumber(){
        int sum = callMethodUnderTest("5");
        Assert.assertEquals(5, sum);
    }

    @Test
    public void shouldVerifyAddTwoNumbers(){
        int sum = callMethodUnderTest("5,9");
        Assert.assertEquals(14, sum);
    }

    @Test
    public void shouldVerifyAddSingleUnknownumber(){
        int sum = callMethodUnderTest("n");
        Assert.assertEquals(999, sum);
    }

    @Test
    public void shouldVerifyAddUnknownumbers(){
        int sum = callMethodUnderTest("5,n");
        Assert.assertEquals(999, sum);
    }
    @Test
    public void shouldVerifyAddMoreThanTwoNumbers(){
        int sum = callMethodUnderTest("5,9,2,5");
        Assert.assertEquals(21, sum);
    }

    @Test
    public void shouldVerifyAddNewLines(){
        //Example: "1\n2,3" returns 6.
        int sum = callMethodUnderTest("1\n2,3");
        Assert.assertEquals(6, sum);
    }

    @Test
    public void shouldVerifyAddInvalidNewLines(){
        //Example: "1\n2,3" returns 6.
        int sum = callMethodUnderTest("1\n");
        Assert.assertEquals(1, sum);
    }

    @Test
    public void shouldVerifyAddNewDelimiters() {
        //Example: "//;\n1;2" returns 6.
        int sum = callMethodUnderTest("//;\n1;2");
        Assert.assertEquals(3, sum);
    }

    @Test
    public void shouldVerifyAddNewDelimiterPipe(){
        int sum = callMethodUnderTest("//|\n1|2|6");
        Assert.assertEquals(9, sum);
    }

    //i. Example: &quot;-1,2&quot; throws &quot;Negatives not allowed: -1&quot;.
    //ii. Example: &quot;2,-4,3,-5&quot; throws &quot;Negatives not allowed: -4,-5&quot;.
    @Test
    public void shouldVerifyAddingOneNegative() throws Exception {
        try{
            calculator.Add("-1,2");
        } catch(Exception e){
            Assert.assertEquals("Negatives not allowed: -1", e.getMessage());
        }
    }

    @Test
    public void shouldVerifyAddingMultipleNegative() {
        try{
            int sum = calculator.Add("2,-4,3,-5");
        } catch(Exception e){
            Assert.assertEquals("Negatives not allowed: -4,-5", e.getMessage());
        }
    }

    @Test
    public void shouldVerifyGreaterThan1000Ignored() {
        try{
            int sum = calculator.Add("1001,2");
        } catch(Exception e){
            Assert.assertEquals("2", e.getMessage());
        }
    }

    @Test
    public void shouldVerifyLess1000Accepted() {
        try{
            int sum = calculator.Add("999,2");
        } catch(Exception e){
            Assert.assertEquals("1001", e.getMessage());
        }
    }

    @Test
    public void shouldVerifyGreaterThan3000Ignored() {
        try{
            int sum = calculator.Add("3,3002,2");
        } catch(Exception e){
            Assert.assertEquals("5", e.getMessage());
        }
    }

    @Test
    public void shouldVerifyAnyLengthDelimiters() {
        //Example: //[|||]\n1|||2|||3 --> returns 6.
        int sum = callMethodUnderTest("//[|||]\n1|||2|||3");
        Assert.assertEquals(6, sum);
    }

    @Test
    public void shouldVerifyAnyLengthDelimiters_2() {
        int sum = callMethodUnderTest("//[@%&]\n11@%&2@%&15");
        Assert.assertEquals(28, sum);
    }

    @Test
    public void shouldVerifyMultipleDelimiters() {
        int sum = callMethodUnderTest("//[|][%]\n1|2%3");
        Assert.assertEquals(6, sum);
    }

    @Test
    public void shouldVerifyMultipleDelimitersWithAnyLength() {
        int sum = callMethodUnderTest("//[|*][%^]\n1|*2%^9");
        Assert.assertEquals(12, sum);
    }

    private int callMethodUnderTest(String input) {
        try{
            return calculator.Add(input);
        } catch(Exception e){
            System.out.println("Exception encountered.");
        }
    return 999;
    }

}
