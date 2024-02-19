import java.util.Arrays;

public class StringCalculator {

    private String negativeNumbers = "";
    private String delimiter = "[,\n]";

    public int Add(String input) throws Exception {

        input = processNewDelimiterAndInput(input);

        String[] numbers = input.split(delimiter);
        try {
            if (numbers.length == 1) {
                if (numbers[0].isEmpty()) {
                    return 0;
                }
                return Integer.parseInt(numbers[0]);
            } else {
                int total = 0;
               // String negativeNumbers = "";
                for(String num : numbers) {
                    if (!checkNegativeNumbers(num)) {
                        int value = Integer.parseInt(num);
                        if (value <= 1000) {
                            //Ignore anything > 1000
                            total += Integer.parseInt(num);
                        }
                    }
                }

                if (!negativeNumbers.isEmpty()) {
                    throw new Exception("Negatives not allowed: " + negativeNumbers);
                }

                return total;
            }
        } catch(NumberFormatException ex){
            //Anything that isn't number is returned with 999 - Client will know this is an invalid scenario
            return 999;
        }
    }

    /**
     * This is a helper method that identifies whether a new delimiter is provided and if so, it sets the new delimiter and
     * sends back the new input data (excluding the delimiter information)
     * @param input
     * @return if New delimiter exists, newInput string is returned else, original input data is returned
     */
    private String processNewDelimiterAndInput(String input){
        if (input.startsWith("//")) {
            String[] newInput = input.split("\n");
            delimiter = newInput[0].replace("//", "").replace("[", "").replace("]", "");
            delimiter = "[" + delimiter + "]+";
            return newInput[1];
        }
        return input;
    }

    /**
     * This method checks if provided number is a negative value, and if it is, it adds the value in the global
     * String NegativeNumbers parameter which gets sent back as the Exception Message.
     * @param num
     * @return true if value is a negative number else, returns false.
     */
    private boolean checkNegativeNumbers(String num){
        if (num.contains("-")) {
            if (negativeNumbers.length()>1) {
                negativeNumbers += ",";
            }
            negativeNumbers += num;
            return true;
        }
        return false;
    }

}
