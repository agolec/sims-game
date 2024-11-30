package entities.base;

import java.util.ArrayList;
import java.util.List;

public abstract class Location {
    private String name;
    private String description;
    private List<Location> connections;

    public Location(String name, String description){
        if(name == null){
            throw new IllegalArgumentException("Error: Name cannot be null.");
        }
        if(name.trim().isBlank() || name.trim().isEmpty()){
            throw new IllegalArgumentException("Error: Location name cannot be blank or empty.");
        }
        if(description == null){
            throw new IllegalArgumentException("Error: Location Description cannot be null.");
        }
        if(description.trim().isEmpty() || description.trim().isBlank()){
            throw new IllegalArgumentException("Error: Location Description cannot be empty or blank.");
        }
        this.name = name;
        this.description = description;
        this.connections = new ArrayList<>();
    }

    /**
     *
     * @param location - Location to be added as a connection to this location.
     *
     *                 If location being provided to this argument is not
     *                 in the connections list, it will be added.
     *
     *                 If calling location argument provided to this object is added to this Location connections
     *                 list, this location is also added to the calling location's connection for bidirectionality.
     */
    public void addConnection(Location location){
        if(location == this){
            throw new IllegalArgumentException("Error: location cannot connect to itself.");
        }
        if(location != null){
            if(!this.connections.contains(location)){
                this.connections.add(location);
                location.addConnection(this);

            }
        }
    }

    /**
     *
     * @param location - Location to be removed from this Location's connection list.
     *
     *                 If the Location being provided is in this location's connection list, it will be removed.
     *                 When the calling location is removed from this location's connections, it is also
     *                 removed from the calling object's connections to maintain bi-directionality.
     */
    public void removeConnection(Location location){
        if(location == this){
            System.out.println("Error: Tried to remove connection to self.");
            return;
        }
        if(location != null){
            if(this.connections.contains((location))){
                this.connections.remove(location);
                location.removeConnection(this);
            }
        }
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public List<Location> getConnections(){
        return this.connections;
    }
    public String describe(){
        return this.name + ": " + this.description;
    }
}
