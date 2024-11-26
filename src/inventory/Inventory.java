package inventory;
import item.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Item item;
    private List<InventorySlot> inventorySlots;

    public Inventory(){
        this.inventorySlots = new ArrayList<>();
    }
    public void addItem(Item item, int quantity){
        for(InventorySlot slot: this.inventorySlots){
            if(slot.getItem().equals(item)){
                slot.addQuantity(quantity);
                return;
            }
        }
        this.inventorySlots.add(new InventorySlot(item,quantity));
    }

    /**
     *
     * @param item - Item desired to be removed from a sim's inventory.
     * @param quantity - Quantity of item wished to be removed.
     */
    public void removeItem(Item item, int quantity){
        InventorySlot slotToRemove = null;
        for(InventorySlot slot: this.inventorySlots){
            if(slot.getItem().equals(item)){
                if(item.isKeyItem() && slot.getQuantity() <= quantity){
                    System.out.println("Cannot remove the last copy of a key item!");
                    return;
                }

                slot.removeQuantity(quantity);
                if(slot.getQuantity() == 0){
                    slotToRemove = slot;
                }
                break;
            }
        }

        if(slotToRemove != null){
            inventorySlots.remove(slotToRemove);
        }
    }
    public int getInventorySize(){
        return this.inventorySlots.size();
    }
}
