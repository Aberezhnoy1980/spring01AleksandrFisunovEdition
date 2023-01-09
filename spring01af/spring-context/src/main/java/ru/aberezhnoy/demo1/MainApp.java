package ru.aberezhnoy.demo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aberezhnoy.demo1.cart.CartServiceImpl;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ItemService itemService = context.getBean(ItemService.class);
        CartServiceImpl cs = context.getBean(CartServiceImpl.class);
        System.out.println(itemService.getSumPrice());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Please see our today's offer:\n");

        label:
        while (true) {
            System.out.println("Please, choose an action:\n to create a new cart: new \n to add an item text: add \n to remove item text: remove \n to view the current cart text: current order \n to empty current cart text: clear \n to leave text exit");

            String customerChoice = scanner.nextLine();
            switch (customerChoice) {
                case "add":
                    System.out.println("Please, text the product id that you want to add");
                    Long idToAdd = scanner.nextLong();
                    cs.addToCart(idToAdd);
                    break;
                case "remove":
                    System.out.println("Please, text the product id that you want to remove");
                    Long idToRemove = scanner.nextLong();
                    assert false;
                    cs.deleteItemById(idToRemove);
                    break;
                case "show":
                    cs.showOrder();
                    break;
                case "exit":
                    System.out.println("Have a nice day! We hope to see you soon!");
                    break label;
            }
        }
        context.close();
    }
}
