package ru.home.other;

public class Calculator {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		System.out.println("Arguments count is: " + args.length);

		for (int i = 2; i < args.length; i++) {
			System.out.println("Argument " + i + " is " + 
args[i]);
			}	
		System.out.println("Summ of arguments " + args[0] + " and " + args[1] + " is: " + (a + b));
	}		
}
