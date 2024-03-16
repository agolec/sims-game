package buildings;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String name;
    private String address;
    private PropertyType propertyType;
    private List<List<Room>> floors;

    public Building(String name, String address, PropertyType propertyType){
        setName(name);
        setAddress(address);
        setPropertyType(propertyType);
        floors = new ArrayList<>();
    }
    public Building(Building source){
        this.setName(source.getName());
        this.setAddress(source.getAddress());
        this.setPropertyType(source.getPropertyType());
        this.addFloor();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throwIllegalArgumentExceptionForNullOrBlankField(name);
        }
        this.name = name;
    }

    public void setAddress(String address) {
        if(address == null|| address.isBlank()){
            throwIllegalArgumentExceptionForNullOrBlankField(address);
        }
        this.address = address;
    }

    public void setPropertyType(PropertyType propertyType) {
        String fieldName = "Property type";
        if(propertyType == null){
            throwIllegalArgumentExceptionForNullOrBlankField(fieldName);
        }
        this.propertyType = propertyType;
    }
    public void addRoom(int floorIndex, Room room){
        if(floorIndex < 0 || floorIndex >= this.floors.size()){
            throwIllegalArgumentExceptionForInvalidFloorIndex();
        }
    }
    public void deleteRoom(int floorIndex, int roomIndex){
        if(floorIndex < 0 || floorIndex >= this.floors.size()){
            throwIllegalArgumentExceptionForInvalidFloorIndex();
        }
        if(roomIndex < 0 || roomIndex >= floors.get(floorIndex).size()){
            throwIllegalArgumentExceptionForInvalidRoomIndex();
        }
        floors.get(floorIndex).remove(roomIndex);
    }
    public void addFloor(){
        this.floors.add(new ArrayList<>());
    }
    public void deleteFloor(int floorIndex){
        if(floorIndex < 0 || floorIndex >= floors.size()){
            throwIllegalArgumentExceptionForInvalidFloorIndex();
        }
        floors.remove(floorIndex);
    }
    public void throwIllegalArgumentExceptionForNullOrBlankField(String fieldName){
        throw new IllegalArgumentException(fieldName + " cannot be null or blank.");
    }
    public void throwIllegalArgumentExceptionForInvalidFloorIndex(){
        throw new IllegalArgumentException("Invalid floor index.");
    }
    public void throwIllegalArgumentExceptionForInvalidRoomIndex(){
        throw new IllegalArgumentException("Invalid room index.");
    }
}
