package ru.home.factory;

public class GroceryStoreFactory implements StoreFactory {
    @Override
    public Store createStoreAs(StoreType type) {
        return new GroceryStore();
    }

    @Override
    public Store createStore() {
        return new GroceryStore();
    }
}
