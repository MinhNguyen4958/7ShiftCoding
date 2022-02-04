public class StringCalculator {
    public int Add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        String[] num_array = numbers.split(",");
        int sum = 0;
        for (String s : num_array) {
            s = s.replace("\n", "");
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        int failed_count = 0;
        // Request 1
        // Test case 1 - empty String
        int expected = 0;
        int result = calculator.Add("");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }

        //Test case 2
        expected = 14;
        result = calculator.Add("5,6,3");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }

        //Request 2
        //Test case 1
        expected = 6;
        result = calculator.Add("1\n,2,3");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }

        //Test case 2
        expected = 7;
        result = calculator.Add("1,\n2,4");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }
        System.out.println("Test completed: " + failed_count + " failed cases");
    }
}
