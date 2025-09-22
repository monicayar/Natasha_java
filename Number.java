
import java.util.Scanner;
// Import Scanner class

    public class Number {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in); // Correct capitalization

            System.out.print("Enter a number: ");
            int number = input.nextInt(); // Correct method name and variable name

            // Check if the number is divisible by 2
            if (number % 2 == 0) {
                System.out.println("HiEven"); // Strings must be in quotes
            }

            // Check if the number is divisible by 5
            if (number % 5 == 0) {
                System.out.println("HiFive");
            }

            // Close the Scanner
            input.close();
        }
    }



