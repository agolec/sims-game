package item;

import entities.Sim;
import exceptions.InvalidEntityNameException;
import utils.SimUtils;

import java.util.ArrayList;

public class Appliance extends Item {
    //relevent things to appliance class.
    private enum APPLIANCE_STATE {FUNCTIONAL,BROKEN,DIRTY}
    private enum UPGRADE_LEVEL {NONE, UPGRADE1, UPGRADE2}
    private APPLIANCE_STATE state;
    private UPGRADE_LEVEL upgradeLevel;
    //private int appearanceModifier;

    public Appliance(String name, Sim owner, String description, boolean isKeyItem) throws InvalidEntityNameException {
        super(name, owner, description, isKeyItem);
        setState(APPLIANCE_STATE.FUNCTIONAL);

    }
    void use(){
        switch(this.getState()){
            case APPLIANCE_STATE.FUNCTIONAL -> System.out.println("functional" + this.getName());
            case APPLIANCE_STATE.DIRTY -> System.out.println("Dirty " + this.getName());
            case APPLIANCE_STATE.BROKEN -> System.out.println("Broken " + this.getName());
        }
    }
    void repair(){
        System.out.println("Repairing " + this.getName());
        setState(APPLIANCE_STATE.FUNCTIONAL);
    }
    void clean(){
        System.out.println("Cleaning " + this.getName());
        setState(APPLIANCE_STATE.FUNCTIONAL);
    }
    void upgrade(){
        switch(this.upgradeLevel){
            case NONE -> setUpgradeLevel(UPGRADE_LEVEL.UPGRADE1);
            case UPGRADE1 -> setUpgradeLevel(UPGRADE_LEVEL.UPGRADE2);
            default -> System.out.println("upgraded to max.");
        }
    }

    public void setState(APPLIANCE_STATE state){
        this.state = state;
    }
    public void setUpgradeLevel(UPGRADE_LEVEL level){
        this.upgradeLevel = level;
    }
    public APPLIANCE_STATE getState(){
        return this.state;
    }
    public UPGRADE_LEVEL getUpgradeLevel(){
        return this.upgradeLevel;
    }
    public String getStateString(){
        String s = new String();
        return switch(getState()){
            case FUNCTIONAL -> "Functional";
            case DIRTY -> "Dirty";
            case BROKEN -> "Broken";
        };
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("appliance state: ").append(this.getState().toString());
        sb.append("Upgrades: ").append(this.getUpgradeLevel().toString());
        return sb.toString();
    }
}
