package Inventory_OrderManagement;

import java.util.Map;

public class Order {

    int orderId;
    User user;
    Address deliveryAddress;
    Map<Integer, Integer> productCategoryAndCountMap;
    Warehouse warehouse;
    OrderStatus orderStatus;
    Invoice invoice;
    Payment payment;

    Order(User user, Warehouse warehouse)
    {
        this.user = user;
        this.orderId = (int)(Math.random() * 100);
        this.deliveryAddress = user.address;
        productCategoryAndCountMap = user.getUserCart().getCartItems();
        this.warehouse = warehouse;
        this.orderStatus = OrderStatus.SCHEDULED;
        invoice = new Invoice();
    }

    public void checkOut()
    {
        //remove item from inventory
        warehouse.removeItemFromInventory(productCategoryAndCountMap);

        //makePayment
        boolean isPaid = makePayment(new UPI());
        if(isPaid)
        {
            user.getUserCart().emptyCart();
        }else{
            warehouse.addItemToInventory(productCategoryAndCountMap);
        }
    }

    private boolean makePayment(PaymentMode paymentMode)
    {
        payment= new Payment(paymentMode);
        return payment.makePayment();

    }


}
