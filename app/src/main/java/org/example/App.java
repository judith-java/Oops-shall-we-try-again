package org.example;

import java.util.Scanner;

public class App {

  static int lowerBound = 10;
  static int upperBound = 100;
  static String prompt = "Please enter an integer between 10 and 100:";
  static String errorMessage = "Your value is invalid. Please try again.";

  public static int getInput() {
    Scanner scanner = new Scanner(System.in);
    int userInput;

    while (true) {
      System.out.println(prompt);
      if (scanner.hasNextInt()) {
        userInput = scanner.nextInt();
        if (userInput >= lowerBound && userInput <= upperBound) {
          return userInput;
        } else {
          System.out.println(errorMessage);
        }
      } else {
        scanner.next(); 
        System.out.println(errorMessage);
      }
    }
  }

  public static void main(String[] args) {
    int result = getInput();
    System.out.println("The value chosen by the user is " + result);
  }
}
