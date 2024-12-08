package inventory;
import entities.Entity;
import entities.Sim;
import exceptions.InvalidEntityNameException;
import item.Item;
import item.food.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private ArrayList<Item> inventoryItems;

    public Inventory() throws InvalidEntityNameException {

        this.inventoryItems = new ArrayList<>();
    }
    public Inventory(ArrayList<Item> items) throws InvalidEntityNameException {
        this.inventoryItems = new ArrayList<>(items);
    }
    public void addItem(Item item) {
        this.inventoryItems.add(item);
    }
    public void removeOwner(Item item){
        inventoryItems.remove(item);
    }

    /**
     *
     * @param item - Item desired to be removed from a sim's inventory.
     */

    public int getInventorySize(){
        return this.inventoryItems.size();
    }
    public void displayItems(){
        if(this.inventoryItems.isEmpty()){
            System.out.println("No items in inventory.");
        }
        for (int i = 0; i < this.getInventorySize(); i++){
            System.out.println((i + 1) + ". " + inventoryItems.get(i).getName());
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Item item : this.inventoryItems){
            sb.append("-----");
            sb.append(item.toString());
            sb.append("-----");
        }
        return sb.toString();
    }
}
