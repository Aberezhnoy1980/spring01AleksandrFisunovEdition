package ru.home.factory;

public class WearStore implements Store, StoreStatement {
    @Override
    public void saleGood() {
        System.out.println("Awesome wear!");
    }

    @Override
    public void setStatement(String message) {
        System.out.println(message);
    }
}
