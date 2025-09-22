


import java.util.Scanner;

public class PlayerSelection {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Constants
        final double POUND_TO_KG = 0.45359237;
        final int METER_TO_CM = 100;

        // Step 1: Read player details
        System.out.print("Enter Player Name: ");
        String name = input.nextLine();

        System.out.print("Enter Age: ");
        int age = input.nextInt();

        System.out.print("Enter Height (in meters): ");
        double heightMeters = input.nextDouble();

        System.out.print("Enter Weight (in pounds): ");
        double weightPounds = input.nextDouble();

        System.out.print("Enter Jersey Number: ");
        int jerseyNumber = input.nextInt();

        // Step 2: Convert height and weight
        double heightCm = heightMeters * METER_TO_CM;
        double weightKg = weightPounds * POUND_TO_KG;
        int roundedWeightKg = (int) weightKg; // casting to int

        // Step 3: Categorize player by age
        String category;
        if (age < 20) {
            category = "Rising Star";
        } else if (age <= 30) {
            category = "Prime Player";
        } else {
            category = "Veteran";
        }

        // Step 4: Determine player position using switch
        String position;
        switch (jerseyNumber) {
            case 1:
                position = "Goalkeeper";
                break;
            case 2:
            case 5:
                position = "Defender";
                break;
            case 6:
            case 8:
                position = "Midfielder";
                break;
            case 7:
            case 11:
                position = "Winger";
                break;
            case 9:
                position = "Striker";
                break;
            case 10:
                position = "Playmaker";
                break;
            default:
                position = "Unknown Position";
                break;
        }

        // Step 5: Check if jersey number is for attacker
        boolean isAttacker = (jerseyNumber == 7 || jerseyNumber == 9 || jerseyNumber == 11);

        // Step 6: Check eligibility
        boolean eligible = (age >= 18 && age <= 35 && roundedWeightKg < 90);

        // Step 7: Decide starting lineup (nested if)
        String lineupDecision;
        if (category.equals("Prime Player")) {
            if (roundedWeightKg < 80) {
                lineupDecision = "Starting Lineup";
            } else {
                lineupDecision = "Bench";
            }
        } else {
            lineupDecision = "Bench";
        }

        // Step 8: Final decision using ternary operator
        String finalDecision = eligible ? "Play" : "Rest";

        // Step 9: Display the Player Report
        System.out.println("\n======= PLAYER REPORT =======");
        System.out.println("Player: " + name);
        System.out.println("Age: " + age + " (" + category + ")");
        System.out.println("Height: " + String.format("%.2f", heightCm) + " cm");
        System.out.println("Weight: " + roundedWeightKg + " kg");
        System.out.println("Jersey Number: " + jerseyNumber);
        System.out.println("Position: " + position);
        System.out.println("Attacker Jersey: " + (isAttacker ? "Yes" : "No"));
        System.out.println("Eligibility: " + (eligible ? "Eligible" : "Not Eligible"));
        System.out.println("Lineup Decision: " + lineupDecision);
        System.out.println("Final Decision: " + finalDecision);

        // Step 10: Demonstrate fall-through behavior (Task 7)
        System.out.println("\n--- Fall-through Demo ---");
        System.out.println("Testing fall-through with jersey number " + jerseyNumber);

        switch (jerseyNumber) {
            case 2: // Missing break here intentionally
                System.out.println("Case 2: Defender");
            case 6: // Missing break here intentionally
                System.out.println("Case 6: Midfielder");
            case 7: // Missing break here intentionally
                System.out.println("Case 7: Winger");
                break;
            default:
                System.out.println("Default case executed.");
                break;
        }

        input.close();
    }
}
