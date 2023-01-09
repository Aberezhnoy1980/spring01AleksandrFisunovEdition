package ru.home.controlStatements;

public class DoWhileMenu {
    public static void main(String[] args) throws  java.io.IOException  {
        char choice;
        do {
            System.out.println("operators help\n");
            System.out.println("1. if");
            System.out.println("2. switch");
            System.out.println("3. while");
            System.out.println("4. do-while");
            System.out.println("5. for");
            System.out.println("6. foreach\n");
            System.out.println("choose the point, please");
            choice = (char) System.in.read();
            if (choice < '1' || choice > '6') System.out.println("incorrect input, try again, please");
        } while (choice < '1' || choice > '6');

        switch (choice) {
            case '1':
                System.out.println("if (condition) operator; \nelse operator;");
                break;
            case '2':
                System.out.println("switch (condition) {\n    case constant:\n        chain of operators;\n        break;\n    //...\n}");
                break;
            case '3':
                System.out.println("while (condition) operator;");
                break;
            case '4':
                System.out.println("do {\n    operator;\n} while (condition);");
                break;
            case '5':
                System.out.println("for (initialization; condition; iteration) operator;");
                break;
            case '6':
                System.out.println("for (Type iteration variable : collection) chain of operators;");
                break;
        }
    }
}
