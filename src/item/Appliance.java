package item;

import entities.Sim;
import exceptions.InvalidEntityNameException;
import utils.SimUtils;

import java.util.ArrayList;

public abstract class Appliance extends Item {

    private boolean broken;
    private boolean dirty;
    //relevent things to appliance class.

    public Appliance(String name, Sim owner, String description, boolean isKeyItem) throws InvalidEntityNameException {
        super(name, owner, description, isKeyItem);

    }

    public boolean isBroken(){
        return this.isBroken();
    }
    public boolean isDirty(){
        return this.dirty;
    }

    public void setBroken(boolean broken){
        this.broken = broken;
    }
    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }
}
