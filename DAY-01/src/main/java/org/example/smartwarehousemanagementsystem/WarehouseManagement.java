package org.example.smartwarehousemanagementsystem;


import java.util.ArrayList;
import java.util.List;

//Abstract class WarehouseItem
abstract class WarehouseItem {
    String itemName;

    public WarehouseItem(String itemName) {
        this.itemName = itemName;
    }

    //Abstract method display
    public abstract void display();


}

//Electronic class which extends the WarehouseItem class
class Electronics extends WarehouseItem {
    String brandName;
    double price;

    public Electronics(String itemName, String brandName, double price) {
        super(itemName);
        this.brandName = brandName;
        this.price = price;


    }

    @Override
    public void display() {
        System.out.println("ItemName " + itemName + " BranchName " + brandName + " Price " + price);
    }

}

//Groceries class which extends the WarehouseItem class
class Groceries extends WarehouseItem {
    String groceryName;
    double groceryPrice;

    public Groceries(String itemName, String groceryName, double groceryPrice) {
        super(itemName);
        this.groceryName = groceryName;
        this.groceryPrice = groceryPrice;
    }

    @Override
    public void display() {
        System.out.println("ItemName " + itemName + " groceryName " + groceryName + " grocieryPrice " + groceryPrice);
    }
}

//Furniture class which extends the WarehouseItem class
class Furniture extends WarehouseItem {
    String furnitureName;
    double furniturePrice;

    public Furniture(String itemName, String furnitureName, double furniturePrice) {
        super(itemName);
        this.furnitureName = furnitureName;
        this.furniturePrice = furniturePrice;
    }

    @Override
    public void display() {
        System.out.println("ItemName " + itemName + " FurnitureName " + furnitureName + " FurniturePrice " + furniturePrice);
    }
}

//Generic class Storage which extends the WarehouseItem class
class Storage<T extends WarehouseItem> {

    List<T> items; //Declared the list for storing the objects of the Storage class

    public Storage() {
        items = new ArrayList<>();//constructor to initialise the list
    }

    //Add method to add the items in the list
    public void add(T item) {
        items.add(item);
    }

    //getAll methods to get the items of the list
    public List<T> getAll() {
        return items;
    }

    //DisplayAllItems method to display the details the Warehouse items
    public void displayAllItems(List<? extends WarehouseItem> itemList) {

        for (WarehouseItem List : itemList) {
            List.display();
        }
    }
}

public class WarehouseManagement {
    public static void main(String[] args) {

        //Create the objects of the Storage class with ensuring the type safety
        Storage<Electronics> electornics = new Storage<>();
        Storage<Groceries> grociery = new Storage<>();
        Storage<Furniture> furniture = new Storage<>();

        //Add all the objects to the list
        electornics.add(new Electronics("Fridge", "Samsung", 12000));
        grociery.add(new Groceries("Potato", "Vegetable", 30));
        furniture.add(new Furniture("Sofa", "SofaSet", 30000));

        System.out.println("Electronics ");
        electornics.displayAllItems(electornics.getAll());

        System.out.println("Grocieries ");
        grociery.displayAllItems(grociery.getAll());

        System.out.println("Furniture");
        furniture.displayAllItems(furniture.getAll());

    }
}
