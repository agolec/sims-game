package buildings;

public class Room {
    private String name;
    private int area; // in square feet, for example
    // You can add more properties as needed

    public Room(String name, int area) {
        setName(name);
        setArea(area);
    }
    public Room(Room source){
        this.setName(source.getName());
        this.setArea(source.getArea());
    }

    // Getters and setters as needed
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
    public String toString(){
        return "Room Name: " + this.getName() + "."
                +"\nRoom Area: " + this.getArea() + ".";
    }
}