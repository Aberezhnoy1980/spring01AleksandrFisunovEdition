package ru.home.factory;

public class WearStoreFactory implements StoreFactory {
    @Override
    public Store createStoreAs(StoreType type) {
        return new WearStore();
    }

    @Override
    public Store createStore() {
        return new WearStore();
    }
}
