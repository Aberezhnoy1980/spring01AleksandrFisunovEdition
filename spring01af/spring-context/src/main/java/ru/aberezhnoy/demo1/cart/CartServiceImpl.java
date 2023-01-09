package ru.aberezhnoy.demo1.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.aberezhnoy.demo1.Item;
import ru.aberezhnoy.demo1.ItemService;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class CartServiceImpl implements CartService {

    private final List<Item> cart;

    private final ItemService itemService;

    @Autowired
    public CartServiceImpl(List<Item> cart, ItemService itemService) {
        this.cart = new ArrayList<>();
        this.itemService = itemService;
    }

    @Override
    public void addToCart(Long id) {
        cart.add(itemService.findById(id));
    }

    @Override
    public void deleteItemById(Long id) {
        cart.remove(itemService.findById(id));
    }

    @Override
    public void showOrder() {
        for (Item i : cart) {
            System.out.println(i);
        }
    }
}







