package ru.aberezhnoy.stack;

public class Bracket {
    private final String input;

    public Bracket(String in) {
        input = in;
    }

    public void check() {
        int size = input.length();
        Stack<Character> stack = new StackImpl<>(size);


        for (int i = 0; i < size; i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '[':
                case '{':
                case '(':
                    stack.push(ch);
                    break;
                case ']':
                case '}':
                case ')':
                    if (!stack.isEmpty()) {
                        char chr = stack.pop();
                        if ((ch == '}' && chr != '{') || (ch == ']' && chr != '[') || (ch == ')' && chr != '(')) {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                        System.out.println("All brackets are closed");
                    } else System.out.println("Error: missing left delimiter: " + ch + " at " + i);
                    break;
                default:
                    break;
            }
        }
//        stack.display();
        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}






