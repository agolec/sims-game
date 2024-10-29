package Item;

import entities.Entity;
import entities.Sim;
import exceptions.InvalidEntityNameException;
import exceptions.InvalidItemPriceException;
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
    public Item(String name, ItemType type, Sim owner, Double price, String description) throws InvalidEntityNameException, InvalidItemPriceException {
        super(name);
        this.setType(type);
        this.setOwner(owner);
        this.setPrice(price);
        this.setDescription(description);
    }
    public Item(String name, ItemType type, Sim owner, Double price) throws InvalidEntityNameException, InvalidItemPriceException {
        super(name);
        this.setType(type);
        this.setOwner(owner);
        this.setPrice(price);
        this.setDescription("");
    }
    public abstract void use();
    public abstract Item addToInventory();
    public void setType(ItemType type){
        this.type = type;
    }

    /**
     *
     * @param intendedOwner - The sim the Item is trying to apply ownership to.
     * @throws InvalidEntityNameException - If Sim Entity does not have a name assigned to them, this will be thrown
     */
    public void setOwner(Sim intendedOwner) throws InvalidEntityNameException {
        this.owner = (SimUtils.simExists(intendedOwner)) ? new Sim(intendedOwner): null;
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
    public Sim getOwner(){
        return this.owner;
    }
    public Double getPrice(){
        return this.price;
    }
    public String getDescription(){
        return this.description;
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
