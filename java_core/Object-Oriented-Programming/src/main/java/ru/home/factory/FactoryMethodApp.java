package ru.home.factory;

public class FactoryMethodApp {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("Start Factory Method App!");
        System.out.println("**************************\n");

        System.out.println("1 expression: direct instance creation by specifying the class in the data type\n");
        GroceryStore nativeStore = new GroceryStore();
        nativeStore.sales();
        nativeStore.saleGood();
        nativeStore.setStatement("we can invoke all method, both those belonging to the class and interfaces");

        System.out.println("\n2 expression: instance creation by specifying an interface in the data type\n");
        Store simpleStore = new GroceryStore();
        simpleStore.saleGood();
        simpleStore.setStatement("we can't invoke own class method, because we limited by the interfaces");


        System.out.println("\n3 expression: instance creating using to variational factory with enum\n and invoke class own method due to cast interface object to class object\n");
//        StoreFactory sf = new VarStoreFactory();
//        Store store2 = sf.createStoreAs(StoreType.WEAR);
        Store  varStore = new VarStoreFactory().createStoreAs(StoreType.GROCERY);
        varStore.saleGood();
        ((GroceryStore) varStore).sales();
        varStore.setStatement("holidays from 03 to 05 of May");

        System.out.println("\n4 expression\n");
        StoreFactory storeFactoryGrocery = new GroceryStoreFactory();
        Store groceryStore = storeFactoryGrocery.createStore();
        groceryStore.saleGood();

        System.out.println("\n5 expression\n");
        StoreFactory storeFactoryWear = new WearStoreFactory();
        Store wearStore = storeFactoryWear.createStore();
        wearStore.saleGood();
        wearStore.setStatement("sorry, we are closed for accounting revision");

        System.out.println("\n**************************");
        System.out.println("Factory Method is Done");
    }
}
