package inventory;

import item.Item;

public interface InventoryHolder {
    Inventory getInventory();
    void addItemToInventory(Item item, int quantity);
    void removeItemFromInventory(Item item, int quantity);
    int getInventorySize();
}
