package item.food;

import entities.Sim;
import exceptions.InvalidEntityNameException;
import item.Item;

public class FoodItem extends Item {
    final int NO_MORE_USES = 0;
    int uses;
    int energyProvided;

    public FoodItem(String name, Sim owner, String description, boolean isKeyItem,int uses,int energyProvided) throws InvalidEntityNameException {
        super(name, owner, description, isKeyItem);
        setUses(uses);
        setEnergyProvided(energyProvided);


    }
    public FoodItem(FoodItem sourceItem) throws InvalidEntityNameException {
        super(sourceItem.getName(),sourceItem.getOwner(),sourceItem.getDescription(),sourceItem.isKeyItem());
        this.setUses(sourceItem.getUses());
        this.setEnergyProvided(sourceItem.getEnergyProvided());
    }
    public boolean isEmpty(){
        return getUses() == NO_MORE_USES;
    }
    public int getUses(){
        return this.uses;
    }
    public int getEnergyProvided(){
        return this.energyProvided;
    }
    public void setUses(int uses){
        this.uses = uses;
    }
    public void setEnergyProvided(int energyProvided){
        this.energyProvided = energyProvided;
    }
    public String toString(){
        String usesLeftLabel = "Uses Left: ";
        String energyProvidedLabel = "Energy Provided: ";

        StringBuilder sb = new StringBuilder();
        sb.append(super.getString());
        sb.append(usesLeftLabel).append(this.getUses()).append("\n");
        sb.append(energyProvidedLabel).append(this.getEnergyProvided());
        return sb.toString();
    }
}
