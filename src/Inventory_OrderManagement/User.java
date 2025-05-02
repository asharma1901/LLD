package Inventory_OrderManagement;

import java.util.ArrayList;
import java.util.List;

public class User {

    int userId;
    String userName;
    Cart cart;
    List<Integer> orderIds;
    Address address;

    public User(){
        cart = new Cart();
        orderIds = new ArrayList<>();
    }

    public Cart getUserCart(){
        return cart;
    }
}
