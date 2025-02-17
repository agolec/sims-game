package entities;

import exceptions.InvalidEntityNameException;

public abstract class Entity {
    private String name;
    private static int instanceCount;
    private int entityId;

    public Entity(String name) throws InvalidEntityNameException {
        this.generateId();
        if(name == null || name.isBlank() || name.isEmpty()){
            throw new InvalidEntityNameException("Error: Entity name cannot be blank, null, or empty.");
        }
        setName(name);
    }
    private void generateId(){
        this.entityId = ++instanceCount;
    }
    private void setName(String name){
        this.name = name;
    }
    public int getId(){
        return this.entityId;
    }
    public String getName(){
        return this.name;
    }
    public String getTypeName(){return this.getClass().getSimpleName();}
    public String getString(){
        return "ID: " + this.getId() + "\n" +
        "Name: " + this.getName() + ".";
    }



}
