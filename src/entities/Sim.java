package entities;

import exceptions.InvalidEntityNameException;
import inventory.Inventory;
import inventory.InventoryHolder;
import item.Item;

public class Sim extends Entity implements InventoryHolder {

    private Inventory inventory;
    public Sim(String name) throws InvalidEntityNameException {
        super(name);
    }
    public Sim(String name, Inventory inventory) throws InvalidEntityNameException{
        super(name);
        this.inventory = inventory;
    }
    public Sim(Sim sourceSim) throws InvalidEntityNameException{
        super(sourceSim.getName());
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public void addItemToInventory(Item item, int quantity) {
        this.inventory.addItem(item,quantity);
    }

    @Override
    public void removeItemFromInventory(Item item, int quantity) {
        this.inventory.removeItem(item,quantity);
    }

    @Override
    public int getInventorySize() {
        return this.inventory.getInventorySize();
    }
}
