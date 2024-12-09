package entities;

import entities.base.Interactable;
import exceptions.InvalidEntityNameException;
import inventory.Inventory;
import item.Item;

import java.util.ArrayList;

public class Sim extends Entity {

    private Inventory inventory;
    public Sim(String name) throws InvalidEntityNameException {
        super(name);
        this.inventory = new Inventory();
    }
    public Sim(String name, ArrayList<Item> items) throws InvalidEntityNameException{
        super(name);
        this.inventory = new Inventory(items);
    }
    public Sim(Sim sourceSim) throws InvalidEntityNameException{
        super(sourceSim.getName());
    }
    public Inventory getInventory(){
        return this.inventory;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.getString());
        sb.append(getInventory().toString());
        return sb.toString();
    }
}
