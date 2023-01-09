package ru.aberezhnoy.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserService userService;

    private final ItemService itemService;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserService userService, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.itemService = itemService;
    }

    public void createOrder(String username, List<Long> itemsIds) {
        Order order = new Order();
        User user = userService.findByUsername(username);
        // order.setUser(user);
        List<Item> items = itemService.findByIds(itemsIds);
        // order.setItems(item);
        orderRepository.save(order);
    }
}
