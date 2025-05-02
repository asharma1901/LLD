package Inventory_OrderManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {

    List<Order> orderList;
    Map<Integer, List<Order>> userIdVsOrdersMap;

    OrderController(){
        orderList = new ArrayList<>();
        userIdVsOrdersMap = new HashMap<>();
    }


    //create New Order
    public Order createOrder(User user, Warehouse warehouse)
    {
        Order order = new Order(user,warehouse);
        orderList.add(order);

        if(userIdVsOrdersMap.containsKey(user.userId))
        {
            List<Order> userOrders = userIdVsOrdersMap.get(user.userId);
            userOrders.add(order);
            userIdVsOrdersMap.put(user.userId, userOrders);
        }else{
            List<Order> userOrders = new ArrayList<>();
            userOrders.add(order);
            userIdVsOrdersMap.put(user.userId, userOrders);
        }

        user.orderIds.add(order.orderId);

        return order;
    }

    public void removeOrder(Order order)
    {

    }

    public List<Order> getOrderByCustomerId(int userId){
        return null;
    }

    public Order getOrderByOrderId(int orderId){
        return null;
    }


}
