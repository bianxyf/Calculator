import java.util.Arrays;

public class StringCalculator {

    public int Add(String input){
        String[] numbers = input.split("[,\n]");
        try {
            if (numbers.length == 1) {
                if (numbers[0].isEmpty()) {
                    return 0;
                }
                return Integer.parseInt(numbers[0]);
            } else {
                int total = 0;
                for(String num : numbers) {
                    total += Integer.parseInt(num);
                }
                return total;
            }
        } catch(NumberFormatException ex){
            return 999;
        }
    }

}
