package ru.home.factory;

public class GroceryStore implements Store, StoreStatement {
    @Override
    public void saleGood() {
        System.out.println("Tasty food.");
    }

    @Override
    public void setStatement(String message) {
        System.out.println(message);
    }

    public void sales() {
        System.out.println("Today awesome sales!");
    }
}
