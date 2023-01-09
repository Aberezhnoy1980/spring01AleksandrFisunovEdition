package ru.home.controlStatements;

// check for prime numbers
public class ForFindPrime {

    static java.util.Scanner sc = new java.util.Scanner(System.in);

    public static void main(String[] args) throws java.io.IOException {

//        int num = System.in.read();

        int num = 0;
//        while (!sc.next().equalsIgnoreCase("end")) {
        while (num != 1) {
//        while (!Integer.toString(sc.nextInt()).equalsIgnoreCase("end")) {
            num = sc.nextInt();
            System.out.println(num);
            boolean isPrime;

            if (num < 2) isPrime = false;
            else isPrime = true;

//        isPrime = num < 2 ? false : true;

            for (int i = 2; i <= num / i; i++) {
                if ((num % i) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) System.out.println("Prime number");
            else System.out.println("Not a prime number");
        }
    }
}
