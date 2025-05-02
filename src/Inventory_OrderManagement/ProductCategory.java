package Inventory_OrderManagement;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {

    int categoryId;
    String categoryName;
    List<Product> productList = new ArrayList<>();
    int price;


    public void addProduct(Product product)
    {
        productList.add(product);
    }

    public void removeProduct(int count)
    {
        int removeItems = Math.min(productList.size(), count);

       while(!productList.isEmpty() && removeItems>0){
            productList.remove(0);
            removeItems--;
        }
    }

    public List<Product> getProductList()
    {
        return new ArrayList<>(productList);
    }

}
