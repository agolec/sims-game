package entities;

import exceptions.InvalidEntityNameException;

public class Sim extends Entity {
    public Sim(String name) throws InvalidEntityNameException {
        super(name);
    }
}
