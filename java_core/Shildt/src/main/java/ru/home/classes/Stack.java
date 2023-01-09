package ru.home.classes;

public class Stack {
    // initiate stack with capacity 10 integer values
    int[] stack = new int[10];
    int tos;

    // initiate vertex
    Stack() {
        tos = -1;
    }

    // push an element on the stack
    void push(int item) {
        if (tos == 9) System.out.println("Stack is full");
        else stack[++tos] = item;
    }

    // pop an element from the stack
    int pop() {
        if (tos < 0) {
            System.out.println("stack is empty");
            return 0;
        } else return stack[tos--];
    }
}

class TestStack {
    public static void main(String[] args) {
        Stack myStack1 = new Stack();
        Stack myStack2 = new Stack();

        for (int i = 0; i < 10; i++) myStack1.push(i);
        for (int i = 10; i < 20; i++) myStack2.push(i);

        System.out.println("Stack myStack1 contains: ");
        for (int i = 0; i < 10; i++) System.out.println(myStack1.pop());

        System.out.println("Stack myStack2 contains: ");
        for (int i = 0; i < 10; i++) System.out.println(myStack2.pop());
    }
}