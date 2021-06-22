package ru.home.java1;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    public static Random rnd = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        guessTheNumber();
//        guessTheNumber2();
    }

    public static void guessTheNumber() {
        do {
            System.out.println("Try to guess the secret number from 0 to 9. You have three attempts.");
            int secretNumber = rnd.nextInt(9);
            int attemptCount = 3;
            while (attemptCount > 0) {
                int playerAnswer = scanner.nextInt();
                if (playerAnswer == secretNumber) {
                    System.out.println("Congratulation! You guessed! Do you want to play again? Yes/No");
                    break;
                } else if (playerAnswer < secretNumber) {
                    attemptCount--;
                    System.out.println("Your number is less than secret. Try again. Attempts left " + attemptCount);
                } else {
                    attemptCount--;
                    System.out.println("Your number is greater than guesswork. Try again. Attempts left " + attemptCount);
                }
                if (attemptCount == 0) {
                    System.out.println("Game over, sorryamba. The secret number was " + secretNumber);
                }
            }
            System.out.println("Would you like to play again? Yes/No");
        }
        while (scanner.next().equals("Yes"));
    }
    public static void guessTheNumber2() {
        do {
        System.out.println("Try to guess the secret number from 0 to 9. You have three attempts.");
        int number = rnd.nextInt(9);
        int count = 0;
        int guess = -1;
        while (count < 3 && guess != number) {
            System.out.print("Guess the number (0..9): ");
            guess = scanner.nextInt();
            if (number != guess) {
                System.out.println("Your number is " +
                        ((guess > number) ? "greater" : "less"));
                count++;
            }
        }
        System.out.println("You " +
                ((guess == number) ? "WIN!" : "Lose: " + number));
        System.out.println("Repeat game? Yes - 1, No - 0");
        } while (scanner.nextInt() == 1);
    }

    public static void guessTheWord () {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int secretWord = rnd.nextInt(words.length);
        System.out.println("PLease try to guess the hidden word");


    }
}

