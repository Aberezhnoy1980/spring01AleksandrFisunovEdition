package ru.home.factory;

public class VarStoreFactory implements StoreFactory {

    private StoreType storeType;

    @Override
    public Store createStoreAs(StoreType type) {
        switch (type) {
            case GROCERY:
                return new GroceryStore();
            case WEAR:
                return new WearStore();
        }
        throw new IllegalStateException("type not found");
    }

    @Override
    public Store createStore() {
        return null;
    }
}

