package org.example;

import java.util.Scanner;
import java.util.Optional;

public class App {

    static int lowerBound = 10;
    static int upperBound = 100;
    static int defaultValue = 50;  // Default value example
    static String prompt = String.format(
        "Please enter an integer between %d and %d.\n" +
        "Enter \"default\" to use the default value of %d.\n" +
        "Enter \"exit\" to abort.",
        lowerBound, upperBound, defaultValue
    );
    static String errorMessage = "Your value is invalid. Please try again.";

    /**
     * Get validated input from user with support for default value and exit.
     * @param lowerBound lower bound for valid integer input
     * @param upperBound upper bound for valid integer input
     * @param prompt prompt message displayed to user
     * @param errorMessage error message displayed for invalid input
     * @param defaultValue optional default value that user can accept by typing "default"
     * @return Optional<Integer> returns empty if user aborts, otherwise contains a valid integer
     */
    public static Optional<Integer> getInput(
            int lowerBound,
            int upperBound,
            String prompt,
            String errorMessage,
            int defaultValue
    ) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                // User wants to abort input
                return Optional.empty();
            }

            if (input.equalsIgnoreCase("default")) {
                // User wants to accept default value
                System.out.println("Default value chosen: " + defaultValue);
                return Optional.of(defaultValue);
            }

            try {
                int userInput = Integer.parseInt(input);
                if (userInput >= lowerBound && userInput <= upperBound) {
                    return Optional.of(userInput);
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static void main(String[] args) {
        Optional<Integer> result = getInput(lowerBound, upperBound, prompt, errorMessage, defaultValue);

        if (result.isPresent()) {
            System.out.println("The value chosen by the user is " + result.get());
        } else {
            // User aborted the input process
            System.out.println("Input aborted by the user. Program ending.");
        }
    }
}
