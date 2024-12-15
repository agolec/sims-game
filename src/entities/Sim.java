package entities;

import entities.base.Interactable;
import exceptions.InvalidEntityNameException;
import inventory.Inventory;
import item.Item;
import item.food.FoodItem;

import java.util.ArrayList;
import java.util.Collection;

public class Sim extends Entity {
    private Inventory inventory;
    private ArrayList<Need> needs;
    public Sim(String name) throws InvalidEntityNameException {
        super(name);
        this.inventory = new Inventory();
        ArrayList<Need> needMap = new ArrayList<>();
        needMap.add(new Need("Hunger",100,1));
        setInitialNeeds(needMap);
    }
    public Sim(String name, ArrayList<Item> items) throws InvalidEntityNameException{
        super(name);
        this.inventory = new Inventory(items);
        this.needs = new ArrayList<>();
    }
    public Sim(Sim sourceSim) throws InvalidEntityNameException{
        super(sourceSim.getName());
    }
    public Inventory getInventory(){
        return this.inventory;
    }
    public Need getNeed(String name){
        for(Need need: this.needs){
            if(need.getName().equalsIgnoreCase(name)){
                return new Need(need);
            }
        }
        return null;
    }

    public void consume(Item item){
        if(item instanceof FoodItem == false){
            System.out.println("Item is not food.");
            return;
        }
        for(Need need: this.needs){
            if(need.getName().equalsIgnoreCase("Hunger")){
                need.replenish(((FoodItem) item).getEnergyProvided());
                ((FoodItem) item).setUses(((FoodItem) item).getUses() - 1);
            }
        }
    }
    public void setInitialNeeds(ArrayList<Need> needs){
        this.needs = new ArrayList<>();
        for(Need need: needs){
            this.needs.add(new Need(need.getName(),need.getValue(),need.getDecayRate()));
        }
    }
    public void decayNeed(String name,int decayAmount,int decayQuantity){
        for(Need need: this.needs){
            if(need.getName().equalsIgnoreCase(name)){
                need.decayNeed(decayAmount * decayQuantity);
            }
        }
    }
    public void setNeed(String name,int newValue){
        for(Need need: this.needs){
            if(need.getName().equalsIgnoreCase(name)){
                need.replenish(newValue);
                return;
            }
        }
        System.out.println("Need not found.");
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.getString());
        sb.append(getInventory().toString());
        return sb.toString();
    }
}
