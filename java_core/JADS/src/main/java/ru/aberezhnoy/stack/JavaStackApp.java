package ru.aberezhnoy.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaStackApp {
    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            input = getString();
            System.out.println(input);
            if (input.equals("")) {
                System.out.println("No new brackets for comparison");
                break;
            }

            Bracket bracket = new Bracket(input);
            bracket.check();
        }
    }

    public static String getString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        return bufferedReader.readLine();
    }
}



