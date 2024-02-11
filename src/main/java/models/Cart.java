package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart(List<Product> products) {
        this.products = products;
    }

    public Cart() {
        products= new ArrayList<>();
    }

    public void addProduct(Product productToAdd){
        for (Product product : products){
            if(product.getName().equals(productToAdd.getName())){
                product.addQuantity(productToAdd.getQuantity());
                return;
            }
        }

        products.add(productToAdd);
    }
}
