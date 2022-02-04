public class StringCalculator {
    public int Add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        String[] num_array = numbers.split(",");
        int sum = 0;
        for (String s : num_array) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        int failed_count = 0;
        // Test case 1 - empty String
        int expected = 0;
        int result = calculator.Add("");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }

         expected = 14;
        result = calculator.Add("5,6,3");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }


        System.out.println("Test completed: " + failed_count + " failed cases");
    }
}
