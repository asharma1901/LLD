package Inventory_OrderManagement;

import java.util.List;

public class NearestWarehouseSelection implements WarehouseSelectionStrategy {

    public Warehouse selectWarehouse(List<Warehouse> warehouseList){

        return warehouseList.get(0);
    }


}
