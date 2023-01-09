package ru.home.lesson5.my_lambda;

public class MyLambdaClass {
    public MyLambdaClass(MyFuncInterface target) {
        target.saySomething();
    }

    public MyLambdaClass(MyAnotherFuncInterface target) {
        target.calculateSomething(2,4);
    }

    public MyLambdaClass() {
    }

    public void myLambdaClassMethod(MyFuncInterface myFuncInterface) {
        System.out.println("lambda in class method try");
    }

    public void myLambdaClassMethodWithLogic(MyAnotherFuncInterface myFuncInterface) {
    }
}
