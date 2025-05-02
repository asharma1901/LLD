package Inventory_OrderManagement;

public class UPI implements PaymentMode{

    @Override
    public boolean makePayment() {
        return true;
    }
}
