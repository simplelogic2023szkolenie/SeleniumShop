package models;

import java.math.BigDecimal;

public class Product {
    public Product(String name, BigDecimal price, BigDecimal totalPrice, int quantity) {
        this.name = name;
        this.price = price;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public Product(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = price.multiply(new BigDecimal(quantity));
    }

    private String name;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private int quantity;

    public void addQuantity(int quantityToAdd){
        quantity += quantityToAdd;
        totalPrice = price.multiply(new BigDecimal(quantity));
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
