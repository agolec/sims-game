package entities.locations;

import entities.Entity;
import entities.Sim;
import entities.base.Location;
import item.Item;
import utils.EntityUtils;

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
        if(entity != null){
            this.entitiesInRoom.add(entity);
        }
    }
    public String printRoomEntities(){
        String sb = "";
        int entityCount = 0;
        if(this.entitiesInRoom.isEmpty()){
            return "No entities in Room.";
        }
        for(Entity entity: this.entitiesInRoom){
            entityCount++;
            if(entity instanceof Sim){
                sb += entityCount + " Sim :" + entity.getName() + "\n";
            } else if (entity instanceof Item){
                sb += entityCount + "Item :" + entity.getName() + "\n";
            }
        }
        return sb;
    }
}
