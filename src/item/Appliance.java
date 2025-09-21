package item;

import entities.Sim;
import exceptions.InvalidEntityNameException;
import utils.SimUtils;

import java.util.ArrayList;

public abstract class Appliance extends Item {

    private boolean broken;
    private boolean dirty;
    //relevent things to appliance class.
    //private int appearanceModifier;

    public Appliance(String name, Sim owner, String description, boolean isKeyItem) throws InvalidEntityNameException {
        super(name, owner, description, isKeyItem);

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }
}
