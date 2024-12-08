package item;

import entities.Sim;
import exceptions.InvalidEntityNameException;

import java.util.ArrayList;

public class Appliance extends Item {
    //relevent things to appliance class.
    private enum APPLIANCE_STATE {FUNCTIONAL,BROKEN,DIRTY,UPGRADED}
    private enum UPGRADE_LEVEL {NONE, FIRST, SECOND}
    private APPLIANCE_STATE state;
    private UPGRADE_LEVEL upgradeLevel;
    private int appearanceModifier;

    public Appliance(String name, Sim owner, String description, boolean isKeyItem) throws InvalidEntityNameException {
        super(name, owner, description, isKeyItem);
        setState(APPLIANCE_STATE.FUNCTIONAL);

    }
    void use(){
        switch(this.state){
            case APPLIANCE_STATE.FUNCTIONAL -> System.out.println("functional" + this.getName());
            case APPLIANCE_STATE.DIRTY -> System.out.println("Dirty " + this.getName());
            case APPLIANCE_STATE.BROKEN -> System.out.println("Broken " + this.getName());
            case APPLIANCE_STATE.UPGRADED -> System.out.println("Upgraded " + this.getName());
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
            case NONE -> setUpgradeLevel(UPGRADE_LEVEL.FIRST);
            case FIRST -> setUpgradeLevel(UPGRADE_LEVEL.SECOND);
            default -> System.out.println("upgraded to max.");
        }
    }

    void setState(APPLIANCE_STATE state){
        this.state = state;
    }
    void setUpgradeLevel(UPGRADE_LEVEL level){
        this.upgradeLevel = level;
    }
    UPGRADE_LEVEL getUpgradeLevel(){
        return this.upgradeLevel;
    }
}
