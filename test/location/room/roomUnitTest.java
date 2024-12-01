package location.room;

import entities.Sim;
import entities.locations.Room;
import exceptions.InvalidEntityNameException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class roomUnitTest {
    private Sim testSim;
    private Sim testSim2;
    private Room foyer;

    @Before
    public void setUp() throws InvalidEntityNameException {
        testSim = new Sim("James Earl Jones");
        testSim2 = new Sim("Mark Hamill");
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(foyer);
    }

    @Test
    public void checkRoomCreation(){
        final String ROOM_NAME = this.getClass().getSimpleName().toLowerCase();
        final String ROOM_DESCRIPTION = "a " + ROOM_NAME + " to a home.";

        foyer = new Room(ROOM_NAME,ROOM_DESCRIPTION);
        System.out.println(foyer.printRoomEntities());
        //placing entity in room.
        foyer.addEntity(testSim);
        foyer.addEntity(testSim2);
        System.out.println(foyer.printRoomEntities());
    }

}
