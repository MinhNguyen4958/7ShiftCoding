import java.util.regex.Pattern;

public class StringCalculator {
    public int Add(String numbers) throws NumberFormatException {

        if (numbers.length() == 0) {
            return 0;
        }

        String[] num_array;
        if (numbers.startsWith("//")) {
            int newline_index = numbers.indexOf("\n");
            String delimiter = numbers.substring(2, newline_index);
            String num_string = numbers.substring(newline_index + 1);

            //turn the delimiter into a regex expression
            num_array = num_string.split(Pattern.quote(delimiter));
        } else {
            num_array = numbers.split(",");
        }

        int sum = 0;
        String negative = "";
        for (String s : num_array) {
            s = s.replace("\n", "");
            int number = Integer.parseInt(s);
            if (number < 0) {
                negative += "|" + number + "|";
            } else if ( number < 1000) {
                sum += number;
            }
        }

        if (negative.length() > 0) {
            throw new NumberFormatException("Negatives not allowed: Here are the numbers:" + negative);
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

        //Request 3
        //Test case 1
        expected = 8;
        result = calculator.Add("//;\n1;3;4");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }

        //Test case 2
        expected = 6;
        result = calculator.Add("//$\n1$2$3");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }
        //Test case 3
        expected = 13;
        result = calculator.Add("//@\n2@3@8");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }

        //Request 4

        //Test case 1
        try {
            // Expect an exception throw here
            result = calculator.Add("//@\n2@-2@8");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        //Test case 2
        try {
            result = calculator.Add("//@\n-1@-2@-3@-4");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        //Bonus 1
        //Test case 1
        expected = 10;
        result = calculator.Add("//@\n2@10000@8");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }

        //Test case 2
        expected = 2;
        result = calculator.Add("2,1001");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }

        //Bonus 2

        //Test case 1
        expected = 12;
        result = calculator.Add("//@@@@@@\n2@@@@@@2@@@@@@8");
        if (result != expected) {
            System.out.println("error in the return value!");
            failed_count++;
        }
        System.out.println("Test completed: " + failed_count + " failed cases");
    }
}
