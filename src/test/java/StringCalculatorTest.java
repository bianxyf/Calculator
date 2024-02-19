import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void shouldVerifyAddEmptyString(){
        int sum = calculator.Add("");
        Assert.assertEquals(0, sum);
    }

    @Test
    public void shouldVerifyAddSingleNumber(){
        int sum = calculator.Add("5");
        Assert.assertEquals(5, sum);
    }

    @Test
    public void shouldVerifyAddTwoNumbers(){
        int sum = calculator.Add("5,9");
        Assert.assertEquals(14, sum);
    }

    @Test
    public void shouldVerifyAddSingleUnknownumber(){
        int sum = calculator.Add("n");
        Assert.assertEquals(999, sum);
    }

    @Test
    public void shouldVerifyAddUnknownumbers(){
        int sum = calculator.Add("5,n");
        Assert.assertEquals(999, sum);
    }
    @Test
    public void shouldVerifyAddMoreThanTwoNumbers(){
        int sum = calculator.Add("5,9,2,5");
        Assert.assertEquals(21, sum);
    }

    @Test
    public void shouldVerifyAddNewLines(){
        //Example: "1\n2,3" returns 6.
        int sum = calculator.Add("1\n2,3");
        Assert.assertEquals(6, sum);
    }

    @Test
    public void shouldVerifyAddInvalidNewLines(){
        //Example: "1\n2,3" returns 6.
        int sum = calculator.Add("1\n");
        Assert.assertEquals(1, sum);
    }
}
