package ru.home.factory;

public interface StoreFactory {

    Store createStoreAs(StoreType store);

    Store createStore();
}
