package entities.locations;

import entities.Entity;
import entities.Sim;
import entities.base.Interactable;
import entities.base.Location;
import item.Item;
import java.util.ArrayList;

public class Room  extends Location {
    ArrayList<Entity> entitiesInRoom;
    public Room(String name, String description){
        super(name,description);
        entitiesInRoom = new ArrayList<>();
    }
    public Room(String name, String description, ArrayList<Location> connectingRooms){
        super(name,description,connectingRooms);
        entitiesInRoom = new ArrayList<>();
    }
    public void addEntity(Entity entity){
        if(entity instanceof Interactable){
            this.entitiesInRoom.add(entity);
            return;
        }
        System.err.println("Error: Entity is not interactable. Only an interactable entity can be added to a room.");
    }
    public String printRoomEntities(){
        String entitiesInRoom = "";
        int entityCount = 0;
        if(this.entitiesInRoom.isEmpty()){
            return "No entities in Room.";
        }
        for(Entity entity: this.entitiesInRoom){
            entityCount++;
            entitiesInRoom += entityCount + " " + entity.getTypeName() + " : " + entity.getName() + "\n";
        }
        return entitiesInRoom;
    }
    public ArrayList<Entity> getEntities(){
        return new ArrayList<>(this.entitiesInRoom);
    }

}
