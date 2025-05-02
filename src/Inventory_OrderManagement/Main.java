package Inventory_OrderManagement;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        Address address = new Address(110001, "New Delhi", "Delhi");

        User user = new User();
        user.userId = 1;
        user.userName = "Ayush";
        user.address = address;

        UserController userController = new UserController(new ArrayList<>());
        userController.addUser(user);

        Warehouse warehouse = new Warehouse(address);
        warehouse.inventory = new Inventory();

        warehouse.inventory.addCategory(101, "Electronics", 100);
        warehouse.inventory.addCategory(102, "Books", 50);

        Product p1 = new Product();
        p1.productID = 1;
        p1.productName = "Headphones";

        Product p2 = new Product();
        p2.productID = 2;
        p2.productName = "Java Book";

        warehouse.inventory.addProduct(p1, 101);
        warehouse.inventory.addProduct(p2, 102);

        Cart cart = user.getUserCart();
        cart.addItemInCart(101,1);
        cart.addItemInCart(102, 2);

        System.out.println("Cart Contents: " + cart.getCartItems());

        OrderController orderController = new OrderController();
        Order order = orderController.createOrder(user, warehouse);

        // Checkout
        order.checkOut();



        // View updated inventory
        System.out.println("Updated Inventory After Checkout:");
        for (ProductCategory category : warehouse.inventory.productCategoryList) {
            System.out.println("Category: " + category.categoryName + " | Items Left: " + category.getProductList().size());
        }

        // View order status
        System.out.println("Order Status: " + order.orderStatus);
        System.out.println("Invoice Amount: " + order.invoice.totalAmount());
    }
}
