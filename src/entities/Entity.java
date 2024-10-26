package entities;

import exceptions.InvalidEntityNameException;

public abstract class Entity {
    private String name;
    private int idNumber;

    public Entity(String name) throws InvalidEntityNameException {
        this.generateId();
        if(name.isBlank() || name.isEmpty()){
            throw new InvalidEntityNameException("Error: Entity name cannot be blank or empty.");
        }
    }
    private void generateId(){
        idNumber++;
    }
    public int getId(){
        return this.idNumber;
    }
    public String getName(){
        return this.name;
    }
    public String getString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + this.getId() + "\n");
        sb.append("Name: " + this.getName() + "\n");
        return sb.toString();
    }



}
