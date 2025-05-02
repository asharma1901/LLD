package Inventory_OrderManagement;

public class Invoice {

    int priceBeforeTax;
    int tax;
    int priceAfterTax;

    Invoice()
    {
        this.priceBeforeTax = 100;
        this.tax = 20;
        this.priceAfterTax = this.priceBeforeTax + this.tax;
    }

    public int totalAmount()
    {
        return this.priceAfterTax;
    }
}
