package Item;

import entities.Entity;
import entities.Sim;
import exceptions.InvalidEntityNameException;
import exceptions.InvalidItemPriceException;
import exceptions.InvalidItemQuantityException;
import utils.EntityUtils;
import utils.SimUtils;

/**
 * The Item class is meant to be the base class for any implementation of an item.
 */
public abstract class Item extends Entity {
    private ItemType type;
    private Sim owner;
    private double price;
    private String description;

    boolean keyItem;
    public Item(String name, ItemType type, Sim owner, Double price, String description,boolean isKeyItem) throws InvalidEntityNameException, InvalidItemPriceException {
        super(name);
        this.setType(type);
        this.setOwner(owner);
        this.setPrice(price);
        this.setDescription(description);
        this.setKeyItem(isKeyItem);
    }
    public Item(String name, ItemType type, Sim owner, Double price,boolean isKeyItem) throws InvalidEntityNameException, InvalidItemPriceException {
        super(name);
        this.setType(type);
        this.setOwner(owner);
        this.setPrice(price);
        this.setDescription("");
        this.setKeyItem(isKeyItem());
    }
    public abstract void use();
    public void setType(ItemType type){
        this.type = type;
    }

    /**
     *
     * @param intendedOwner - The sim the Item is trying to apply ownership to.
     * @throws InvalidEntityNameException - If Sim Entity does not have a name assigned to them, this will be thrown
     */
    public void setOwner(Sim intendedOwner) {
        if(hasOwner()){
            this.owner = intendedOwner;
        }
        else {
            this.owner = null;
        }
    }
    //Removes any ownership of the item. Sets it to null.
    public void unsetOwner(){
        this.owner = null;
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

    public void setKeyItem(boolean keyItem) {
        this.keyItem = keyItem;
    } public void setQuantity(int quantity) throws InvalidItemQuantityException {
        if(quantity < 0){
            throw new InvalidItemQuantityException("Error: Quantity for item can not be negative.");
        }
        this.quantity = quantity;
    }

    public ItemType getType(){
        return this.type;
    }
    public Sim getOwner(){
        return this.owner;
    }
    public Double getPrice(){
        return this.price;
    }
    public String getDescription(){
        return this.description;
    }
    public boolean isKeyItem() {
        return this.keyItem;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public boolean hasOwner(){
        return SimUtils.simExists(this.owner);
    }
    public String toString(){

        return "ID: " + super.getId() + "\n" +
                "Type: " + this.getType() + "\n" +
                "Owner" + this.getOwner().getName() + "\n" +
                "Name: " + super.getName() + "\n" +
                "Description" + this.getDescription() + "\n" +
                "Price: $" + this.getPrice();

    }

}
