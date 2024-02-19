import java.util.Arrays;

public class StringCalculator {

    public int Add(String input) throws Exception {
        String delimiter = "[,\n]";
        if (input.startsWith("//")) {
            String[] newInput = input.split("\n");
            delimiter = "["+newInput[0].replace("//","")+"\n]";
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

                    if (num.contains("-")) {
                        if (negativeNumbers.length()>1) {
                            negativeNumbers += ",";
                        }
                        negativeNumbers += num;
                    } else {
                        int value = Integer.parseInt(num);
                        if (value <= 1000) {
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
            return 999;
        }
    }

}
