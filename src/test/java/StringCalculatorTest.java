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

}
