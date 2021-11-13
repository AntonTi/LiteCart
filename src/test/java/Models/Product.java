package test.java.Models;

public class Product {
    public String name;
    public String code;
    public String quantity;
    public String pictureUrl;
    public String shortDescription;
    public String description;
    public String headTitle;
    public String price;

    public Product(String name, String code, int quantity, String pictureUrl, String shortDescription,
                   String description, String headTitle, double price) {
        this.name = name;
        this.code = code;
        this.quantity = String.valueOf(quantity);
        this.pictureUrl = pictureUrl;
        this.shortDescription = shortDescription;
        this.description = description;
        this.headTitle = headTitle;
        this.price = String.valueOf(price);
    }


}
