package item;

import entities.Entity;
import entities.Sim;
import exceptions.InvalidEntityNameException;

/**
 * The Item class is meant to be the base class for any implementation of an item.
 */
public abstract class Item extends Entity  {
    private Sim owner;
    private String description;

    public Item(String name, String description) throws InvalidEntityNameException {
        super(name);
        this.setDescription(description);
    }

    /**
     * description is optional. If String given to description is null for any reason, then an empty string will be given.
     *
     * @param description - A String representing an Item's description.
     */
    public void setDescription(String description) {
        this.description = (description != null) ? description : "";
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(super.getId()).append("\n");
        sb.append("Name: ").append(super.getName()).append("\n");
        sb.append("Description: ").append(this.getDescription()).append("\n");
        return sb.toString();
    }



}
