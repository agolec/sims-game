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
    public void removeOwner(String itemName,boolean removeFromInventory){
        final int ITEM_NOT_FOUND = -1;
        if(itemInInventory(itemName) && getItemIndex(itemName) != ITEM_NOT_FOUND){
            this.inventoryItems.get(getItemIndex(itemName)).setOwner(null);
            if(removeFromInventory){
                System.out.println("Removing" + this.inventoryItems.get(getItemIndex(itemName)) + " from inventory.");
                removeItemFromInventory(itemName);
            }
            System.out.println("Item successfully removed owner from inventory item.");
        } else {
            System.out.println("Item not in inventory.");
        }
    }
    public void removeItemFromInventory(String itemName){
        this.inventoryItems.remove(getItemIndex(itemName));
    }


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
    public Item getItemByIndex(int i){
        return this.inventoryItems.get(i);
    }
    public int getItemIndex(String itemName){
        for(int i = 0; i < this.inventoryItems.size(); i++){
            if(itemInInventory(itemName)){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param itemName - String of an item to search for in an inventory, ignoring case
     * @return - true if present, false if not.
     */
    public boolean itemInInventory(String itemName){
        for(Item item: this.inventoryItems){
            if(item.getName().equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for(Item item : this.inventoryItems){
            sb.append("-----\n");
            sb.append("Item ");
            sb.append(i);
            sb.append("\n");
            sb.append(item.toString());
            sb.append("-----\n");
            i++;
        }
        if(sb.isEmpty()){
            sb.append("no items in inventory.");
        }
        return sb.toString();
    }
}
