package item.food;

import entities.Sim;
import exceptions.InvalidEntityNameException;
import item.Item;

public class FoodItem extends Item {
    final int EMPTY_QUANTITY = 0;
    int quantity;
    int energyProvided;

    public FoodItem(String name, Sim owner, String description, boolean isKeyItem,int quantity,int energyProvided) throws InvalidEntityNameException {
        super(name, owner, description, isKeyItem);
        setQuantity(quantity);
        setEnergyProvided(energyProvided);


    }
    public FoodItem(FoodItem sourceItem) throws InvalidEntityNameException {
        super(sourceItem.getName(),sourceItem.getOwner(),sourceItem.getDescription(),sourceItem.isKeyItem());
        this.setQuantity(sourceItem.getQuantity());
        this.setEnergyProvided(sourceItem.getEnergyProvided());
    }
    public boolean isEmpty(){
        return getQuantity() == EMPTY_QUANTITY;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public int getEnergyProvided(){
        return this.energyProvided;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setEnergyProvided(int energyProvided){
        this.energyProvided = energyProvided;
    }
}
