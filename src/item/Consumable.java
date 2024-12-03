package item;

import entities.Sim;

public interface Consumable {
    public int usesLeft();
    public boolean isEmpty();
    void consume();

}
