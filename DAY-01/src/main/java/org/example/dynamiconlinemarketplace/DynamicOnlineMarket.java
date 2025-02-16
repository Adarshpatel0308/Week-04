package org.example.dynamiconlinemarketplace;

// Book Category
class BookCategory {
    String title;
    String author;

    public BookCategory(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

// Clothing Category
class Clothing {
    String type;

    public Clothing(String type) {
        this.type = type;
    }
}

// Generic Product Class
class Product<T> {
    String name;
    double price;
    T category;  // The category can be any of the classes (BookCategory, Clothing, etc.)

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // toString method for displaying product details
    @Override
    public String toString() {
        return "name: " + name + ", price: " + price + ", category: " + category.getClass().getSimpleName();
    }
}

// DynamicOnlineMarket class to apply discount
public class DynamicOnlineMarket {

    // Generic method to apply discount to any product
    public <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price = product.price * (1 - percentage / 100);
        System.out.println("Discount applied to " + product.name + ": New price = " + product.price);
    }

    public static void main(String[] args) {
        // Create products for different categories
        Product<BookCategory> bookProduct = new Product<>("Grow Rich", 200.0, new BookCategory("Grow Rich", "Yogesh"));
        Product<Clothing> clothingProduct = new Product<>("Sweatshirt", 500.0, new Clothing("Summer Wear"));

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        // Print the original products
        System.out.println(bookProduct);

        System.out.println(clothingProduct);

        // Create the marketplace object to apply discounts
        DynamicOnlineMarket market = new DynamicOnlineMarket();

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");


        // Apply discount on products
        market.applyDiscount(bookProduct, 10);
        market.applyDiscount(clothingProduct, 15);

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

        // Print the products after discount
        System.out.println(bookProduct);

        System.out.println(clothingProduct);
    }
}
