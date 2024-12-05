package item;

import entities.Sim;
import exceptions.InvalidEntityNameException;

public class FoodItem extends Item implements Consumable{
    private final int DECREMENT = 1;
    private final int ZERO = 0;
    private int usesLeft;
    private int energyValue;
    public FoodItem(String name, Sim owner, String description, boolean isKeyItem, int energyValue) throws InvalidEntityNameException {
        super(name, owner, description, isKeyItem);

    }

    /**
     *  non-owner arg for Food item passes null to Item superclass constructor, as null represents an Item with no ownership.
     * @param name
     * @param description
     * @param isKeyItem
     * @throws InvalidEntityNameException
     */
    public FoodItem(String name, String description, boolean isKeyItem,int usesLeft, int energyValue) throws InvalidEntityNameException {
        super(name, null, description, isKeyItem);
        this.setUsesLeft(usesLeft);
        this.setEnergyValue(energyValue);
    }

    @Override
    public int getUsesLeft() {
        return this.usesLeft;
    }
    public int getEnergyValue() { return this.energyValue; }

    public void setUsesLeft(int usesLeft){
        if(usesLeft < 0){
            System.err.println("Error: " + super.getName() + " cannot have negative uses.");
            return;
        }
        this.usesLeft = usesLeft;
    }
    public void setEnergyValue(int energy){
        this.energyValue = energy;
    }

    public void decreaseUsesLeft(int usesConsumed){
        if((this.usesLeft - usesConsumed) < this.ZERO){
            this.usesLeft = this.ZERO;}
        else {
            this.usesLeft -= usesConsumed;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.getUsesLeft() == this.ZERO;
    }

    @Override
    public void consume() {
        final int DECREMENT = 1;
        this.decreaseUsesLeft(DECREMENT);
    }
}
