package item;

import entities.Entity;
import entities.Sim;
import entities.base.Interactable;
import exceptions.InvalidEntityNameException;
import exceptions.InvalidItemPriceException;
import utils.SimUtils;

/**
 * The Item class is meant to be the base class for any implementation of an item.
 */
public abstract class Item extends Entity implements Interactable {
    private Sim owner;
    private String description;
    boolean keyItem;

    public Item(String name, Sim owner, String description, boolean isKeyItem) throws InvalidEntityNameException {
        super(name);
        this.setOwner(owner);
        this.setDescription(description);
        this.setKeyItem(isKeyItem);
    }

    public Item(String name, Sim owner, boolean isKeyItem) throws InvalidEntityNameException {
        super(name);
        this.setOwner(owner);
        this.setDescription("");
        this.setKeyItem(isKeyItem);
    }

    public Item(Item sourceItem) throws InvalidEntityNameException {
        super(sourceItem.getName());
        this.setOwner(sourceItem.getOwner());
        this.setDescription(sourceItem.getDescription());
        this.setKeyItem(sourceItem.isKeyItem());

    }

    /**
     * @param intendedOwner - The sim the Item is trying to apply ownership to.
     */
    public void setOwner(Sim intendedOwner) {
        if (hasOwner()) {
            this.owner = intendedOwner;
        } else {
            this.owner = null;
        }
    }

    //Removes any ownership of the item. Sets it to null.
    public void unsetOwner() {
        this.owner = null;
    }

    /**
     * description is optional. If String given to description is null for any reason, then an empty string will be given.
     *
     * @param description - A String representing an Item's description.
     */
    public void setDescription(String description) {
        this.description = (description != null) ? description : "";
    }

    public void setKeyItem(boolean keyItem) {
        this.keyItem = keyItem;
    }

    public Sim getOwner() {
        return this.owner;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isKeyItem() {
        return this.keyItem;
    }

    public boolean hasOwner() {
        return SimUtils.simExists(this.owner);
    }

    public String toString() {
        String string;
        string = "ID: " + super.getId() + "\n";
        if (this.hasOwner()) {
            string += "Owner; " + this.getOwner().toString();
        } else {
            string += "Owner: none \n";
        }
        string += "Name: " + super.getName() + "\n";
        string += "Key Item: " + this.keyItemText() + "\n";
        string += "Description: " + this.getDescription() + "\n";
        return string;
    }

    /**
     *
     * @return - Test "Yes" if item is a key item. "No" if not. Used when printing Item's toString method.
     */
    private String keyItemText(){
        final String YES = "Yes";
        final String NO = "No";
        return this.isKeyItem() ? YES : NO;
    }

    @Override
    public void interact() {
        System.out.println("Interaction with item...");
    }
}
