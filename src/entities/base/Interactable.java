package entities.base;

import entities.Entity;
import item.action.Action;

import java.util.List;

public interface Interactable {
    List<Action> getAvailableActions();
    void interact(Entity actor, Action action);
}
