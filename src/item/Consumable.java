package item;

import entities.Sim;

public interface Consumable {
    public int getUsesLeft();
    public void setUsesLeft(int usesLeft);
    public boolean isEmpty();
    void consume();

}
