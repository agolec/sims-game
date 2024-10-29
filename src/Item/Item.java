package Item;

import entities.Entity;
import exceptions.InvalidEntityNameException;
import exceptions.InvalidItemPriceException;

/**
 * The Item class is meant to be the base class for any implementation of an item.
 */
public abstract class Item extends Entity {
    private ItemType type;
    private double price;
    private String description;
    public Item(String name, ItemType type, Double price, String description) throws InvalidEntityNameException, InvalidItemPriceException {
        super(name);
        this.setPrice(price);
        this.setDescription(description);
    }
    public Item(String name, ItemType type, Double price) throws InvalidEntityNameException, InvalidItemPriceException {
        super(name);
        this.setPrice(price);
        this.setDescription("");
    }
    public abstract void use();
    public void setType(ItemType type){
        this.type = type;
    }
    public void setPrice(Double price) throws InvalidItemPriceException {
        if(this.price < 0){
            throw new InvalidItemPriceException("Error: Item price less than 0.");
        }
        this.price = price;
    }

    /**
     * description is optional. If String given to description is null for any reason, then an empty string will be given.
     * @param description - A String representing an Item's description.
     */
    public void setDescription(String description){
        this.description = (description != null) ? description : "";
    }
    public ItemType getType(){
        return this.type;
    }
    public Double getPrice(){
        return this.price;
    }
    public String getDescription(){
        return this.description;
    }
    public String toString(){

        return "ID: " + super.getId() + "\n" +
                "Type: " + this.getType() + "\n" +
                "Name: " + super.getName() + "\n" +
                "Description" + this.getDescription() + "\n" +
                "Price: $" + this.getPrice();

    }

}
