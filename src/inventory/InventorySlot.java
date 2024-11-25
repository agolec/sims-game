package inventory;

import item.Item;

public class InventorySlot {
    private Item item;
    private int quantity;
    public InventorySlot(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem(){
        return this.item;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void addQuantity(int quantityToAdd){
        this.quantity += quantityToAdd;
    }
    public void removeQuantity(int quantityToRemove){
        this.quantity = Math.max(0,this.quantity - quantityToRemove);
    }
}
