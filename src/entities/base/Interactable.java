package entities.base;

import item.action.Action;

import java.util.List;

public interface Interactable {
    List<Action> getAvailableActions();

}
