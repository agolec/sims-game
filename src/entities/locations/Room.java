package entities.locations;

import entities.Entity;
import entities.base.Location;

import java.util.ArrayList;

public class Room  extends Location {
    ArrayList<Entity> entitiesInRoom;
    public Room(String name, String description, ArrayList<Location> connectingRooms){
        super(name,description,connectingRooms);
        entitiesInRoom = new ArrayList<>();
    }
}
