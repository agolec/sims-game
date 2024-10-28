package Item;

import entities.Entity;
import exceptions.InvalidEntityNameException;

/**
 * The Item class is meant to be the base class for any implementation of an item.
 */
public abstract class Item extends Entity {
    private ItemType type;
    private double price;
    public Item(String name, ItemType type) throws InvalidEntityNameException {
        super(name);
        this.type = type;
    }
    public abstract void use();
    public void setType(ItemType type){
        this.type = type;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public ItemType getType(){
        return this.type;
    }
    public Double getPrice(){
        return this.price;
    }
    public String toString(){

        return "ID: " + super.getId() + "\n" +
                "Name: " + super.getName() + "\n" +
                "Description" + this.getType() + "\n" +
                "Price: $" + this.getPrice();

    }

}
