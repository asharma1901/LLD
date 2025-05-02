package Inventory_OrderManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {

    List<ProductCategory> productCategoryList;

    Inventory()
    {
        productCategoryList = new ArrayList<>();

    }

    //add new category
    public void addCategory(int productCategoryId, String categoryName, int categoryPrice)
    {
        ProductCategory productCategory = new ProductCategory();
        productCategory.categoryId = productCategoryId;
        productCategory.categoryName = categoryName;
        productCategory.price = categoryPrice;
        productCategoryList.add(productCategory);
    }

    public void addProduct(Product product, int categoryId)
    {
        ProductCategory obj =null;
        for(ProductCategory productCategory :  productCategoryList)
        {
            if(productCategory.categoryId == categoryId)
            {
                obj = productCategory;
            }
        }

        if(obj!=null){
            obj.addProduct(product);
        }
    }

    //remove product from the category
    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap)
    {
        for(Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet())
        {
            ProductCategory productCategory= getProductFromCategoryID(entry.getKey());
            if (productCategory != null) {
                productCategory.removeProduct(entry.getValue());
            }
        }
    }

    //helper function
    private ProductCategory getProductFromCategoryID(int productCategoryID){
        for(ProductCategory productCategory: productCategoryList) {
            if (productCategory.categoryId == productCategoryID) {
                return productCategory;
            }
        }
        return null;
    }

}
