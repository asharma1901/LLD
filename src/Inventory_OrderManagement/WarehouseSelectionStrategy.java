package Inventory_OrderManagement;

import java.util.List;

public interface WarehouseSelectionStrategy {

    public Warehouse selectWarehouse(List<Warehouse> warehouseList);
}
