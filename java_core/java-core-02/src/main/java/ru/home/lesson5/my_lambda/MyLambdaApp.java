package ru.home.lesson5.my_lambda;

public class MyLambdaApp {
    public static void main(String[] args) {

        MyLambdaClass myLambdaClass = new MyLambdaClass(() -> System.out.println("lambda in class, which contains \nconstructor with functional interface in parameter\n"));
        System.out.println("another constructor with another interface: " + new MyLambdaClass((a, b) -> System.out.println(a + b)));

        myLambdaClass.myLambdaClassMethod(() -> System.out.println("lambda in class method"));

//        System.out.println(myLambdaClass.myLambdaClassMethodWithLogic(new MyAnotherFuncInterface() {
//            @Override
//            public void calculateSomething(int a1, int b1) {
//                System.out.println(500 / 5);
//            }
//        }));

        myMethod(() -> System.out.println("lambda in method"));
    }

    public static void myMethod(MyFuncInterface myFuncInterface) {
        System.out.println("lambda in outer method try");
    }
}
