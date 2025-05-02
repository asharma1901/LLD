package Inventory_OrderManagement;

import java.util.List;

public class WarehouseController {

    List<Warehouse> warehouseList;
    WarehouseSelectionStrategy warehouseSelectionStrategy;

    public void addWareHouse(Warehouse warehouse)
    {
        warehouseList.add(warehouse);
    }

    public void removeWareHouse(Warehouse warehouse)
    {
        warehouseList.remove(warehouse);
    }

    public Warehouse selectWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy)
    {
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
        return warehouseSelectionStrategy.selectWarehouse(warehouseList);
    }


}
