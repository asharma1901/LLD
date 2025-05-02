package Inventory_OrderManagement;

import java.util.Map;

public class Warehouse {

    Inventory inventory;
    Address address;

    public Warehouse(Address address) {
        this.address = address;
        this.inventory = new Inventory();
    }

    public void removeItemFromInventory(Map<Integer, Integer> productCategoryAndCountMap)
    {
        inventory.removeItems(productCategoryAndCountMap);
    }

    public void addItemToInventory(Map<Integer, Integer> productCategoryAndCountMap){
    }
}
