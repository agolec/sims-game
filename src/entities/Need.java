package entities;

public class Need {
    private String name;
    private int value;
    private int decayRate;

    public Need(String name, int value, int decayRate){
        this.setName(name);
        this.setValue(value);
        this.setDecayRate(decayRate);
    }
    public Need(Need sourceNeed){
        this.setName(sourceNeed.getName());
        this.setValue(sourceNeed.getValue());
        this.setDecayRate(sourceNeed.getDecayRate());
    }

    public void setValue(int value) {
        this.value = Math.max(0,value); //Floor value at 0. Ceiling value at 100.
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDecayRate(int decayRate) {
        this.decayRate = decayRate;
    }

    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }

    public int getDecayRate() {
        return decayRate;
    }
    public void decayNeed(int amount){
        this.value = Math.max(0,this.value - amount);
    }
    public void replenish(int amount){
        this.value = Math.min(100, this.value + amount); //Cap value at 100.
    }

}
