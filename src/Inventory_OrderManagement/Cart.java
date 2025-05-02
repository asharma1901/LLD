package Inventory_OrderManagement;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    Map<Integer, Integer> productCategoryIdVsCountMap;

    Cart()
    {
        productCategoryIdVsCountMap = new HashMap<>();
    }

    public void addItemInCart(int productCategoryId, int count)
    {
        if(productCategoryIdVsCountMap.containsKey(productCategoryId))
        {
            int noOfItems = productCategoryIdVsCountMap.get(productCategoryId);
            productCategoryIdVsCountMap.put(productCategoryId, noOfItems+count);
        }
        else{
            productCategoryIdVsCountMap.put(productCategoryId, count);
        }
    }

    public void removeItemInCart(int productCategoryId, int count)
    {
        int noOfItems = productCategoryIdVsCountMap.get(productCategoryId);
        if(noOfItems - count==0)
        {
            productCategoryIdVsCountMap.remove(productCategoryId);
        }
        else{
            productCategoryIdVsCountMap.put(productCategoryId, noOfItems - count);
        }
    }

    public void emptyCart()
    {
        productCategoryIdVsCountMap.clear();
    }

    public Map<Integer, Integer> getCartItems()
    {
        return productCategoryIdVsCountMap;
    }

}
