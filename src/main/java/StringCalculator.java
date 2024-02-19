public class StringCalculator {

    public int Add(String input){
        String[] numbers = input.split(",");
        if (numbers.length == 1) {
            if (numbers[0].isEmpty()) {
                return 0;
            }
            return Integer.parseInt(numbers[0]);
        } else {
            return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        }
    }

}
