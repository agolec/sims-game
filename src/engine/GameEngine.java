package engine;

import entities.NonPlayerCharacter;
import entities.PlayerCharacter;

import java.util.ArrayList;

public class GameEngine {
    boolean isRunning;
    private PlayerCharacter player;
    private ArrayList<NonPlayerCharacter> nonPlayerCharacters;

    public GameEngine(){
        isRunning = true;
        this.player = new PlayerCharacter();

    }
}
