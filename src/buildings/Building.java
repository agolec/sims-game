package buildings;

public class Building {
    private String name;
    private String address;
    private PropertyType propertyType;

    public Building(String name, String address, PropertyType propertyType){
        setName(name);
        setAddress(address);
        setPropertyType(propertyType);
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
            illegalArgumentThrow(name);
        }
        this.name = name;
    }

    public void setAddress(String address) {
        if(address == null|| address.isBlank()){
            illegalArgumentThrow(address);
        }
        this.address = address;
    }

    public void setPropertyType(PropertyType propertyType) {
        String fieldName = "Property type";
        if(propertyType == null){
            illegalArgumentThrow(fieldName);
        }
        this.propertyType = propertyType;
    }
    public void illegalArgumentThrow(String fieldName){
        throw new IllegalArgumentException(fieldName + " cannot be null or blank.");
    }
}
