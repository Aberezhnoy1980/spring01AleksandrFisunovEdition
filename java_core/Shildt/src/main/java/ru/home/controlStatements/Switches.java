package ru.home.controlStatements;

public class Switches {
    public static class SampleSwitch {
        public static void main(String[] args) {
            for (int i = 0; i < 6; i++) {
                switch (i) {
                    case 0:
                        System.out.println("i is 0");
                        break;
                    case 1:
                        System.out.println("i is 1");
                        break;
                    case 2:
                        System.out.println("i is 2");
                        break;
                    case 3:
                        System.out.println("i is 3");
                        break;
                    default:
                        System.out.println("i greater than 3");
                }
            }
        }
    }

    static class MissingBreak {
        public static void main(String[] args) {
            for (int i = 0; i < 12; i++) {
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        System.out.println("i less than 5");
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        System.out.println("i less than 10");
                        break;
                    default:
                        System.out.println("i is equal to or greater than 10");
                }
            }
        }
    }

    static class Switch {
        public static void main(String[] args) {
            int month = 4;
            String season = null;
            switch (month) {
                case 12:
                case 1:
                case 2:
                    season = "Winter";
                    break;
                case 3:
                case 4:
                case 5:
                    season = "Spring";
                    break;
                case 6:
                case 7:
                case 8:
                    season = "Summer";
                    break;
                case 9:
                case 10:
                case 11:
                    season = "Autumn";
                default:
                    System.out.println("non-existent month");
            }
            System.out.println("April refer to " + season + ".");
        }
    }

    static class StringSwitch {
        public static void main(String[] args) {
            String str = "two";
            switch (str) {
                case "one":
                    System.out.println("one");
                    break;
                case "two":
                    System.out.println("two");
                    break;
                case "three":
                    System.out.println("three");
                    break;
                default:
                    System.out.println("no matches");
            }
        }
    }
}