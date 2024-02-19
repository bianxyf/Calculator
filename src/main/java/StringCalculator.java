import java.util.Arrays;

public class StringCalculator {

    public int Add(String input) throws Exception {
        String delimiter = "[,\n]";
        if (input.startsWith("//")) {
            //Need to set the new delimiter and input string (excluding the delimiter information)
            String[] newInput = input.split("\n");
            delimiter = newInput[0].replace("//","").replace("[","").replace("]","");
            delimiter = "[" + delimiter + "]+";
            input = newInput[1];
        }

        String[] numbers = input.split(delimiter);
        try {
            if (numbers.length == 1) {
                if (numbers[0].isEmpty()) {
                    return 0;
                }
                return Integer.parseInt(numbers[0]);
            } else {
                int total = 0;
                String negativeNumbers = "";
                for(String num : numbers) {
                    if (!checkNegativeNumbers(num, negativeNumbers)) {
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

    private boolean checkNegativeNumbers(String num, String negativeNumbers){
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
