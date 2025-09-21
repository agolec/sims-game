package item.action;

import entities.Entity;
import entities.base.Interactable;
import item.Item;

public interface Action {
    void perform(Entity actor, Interactable target);
    String getName();
}
