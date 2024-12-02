package location.room;

import entities.Sim;
import entities.locations.Room;
import exceptions.InvalidEntityNameException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class roomUnitTest {

    final String FIRST_SIM_NAME = "James Earl Jones";
    final String SECOND_SIM_NAME = "Mark Hamill";
    private Sim testSim;
    private Sim testSim2;
    private Room foyer;

    @Before
    public void setUp() throws InvalidEntityNameException {

        testSim = new Sim(FIRST_SIM_NAME);
        testSim2 = new Sim(SECOND_SIM_NAME);
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(foyer);
    }

    @Test
    public void checkRoomCreation(){
        final short FIRST_PRIORITY_SIM = 1;
        final short SECOND_PRIORITY_SIM = 2;

        final String ROOM_NAME = this.getClass().getSimpleName().toLowerCase();
        final String SIM_TYPE = "Sim";
        final String ROOM_DESCRIPTION = "a " + ROOM_NAME + " to a home.";
        final String ASSERT_EXPECT_TEXT_NO_ENTITIES_IN_ROOM = "No entities in Room.";
        final String ASSERT_EXPECT_TEXT_ONE_ENTITY_IN_ROOM = FIRST_PRIORITY_SIM + " " + SIM_TYPE + " : " + FIRST_SIM_NAME + "\n";
        final String ASSERT_EXPECT_TEXT_SECOND_ENTITY_IN_ROOM = SECOND_PRIORITY_SIM + " " + SIM_TYPE + " : " + SECOND_SIM_NAME + "\n";

        foyer = new Room(ROOM_NAME,ROOM_DESCRIPTION);
        Assert.assertEquals(ASSERT_EXPECT_TEXT_NO_ENTITIES_IN_ROOM,foyer.printRoomEntities());
        //placing entity in room.
        foyer.addEntity(testSim);
        Assert.assertEquals(ASSERT_EXPECT_TEXT_ONE_ENTITY_IN_ROOM,foyer.printRoomEntities());
        foyer.addEntity(testSim2);
        Assert.assertEquals(ASSERT_EXPECT_TEXT_ONE_ENTITY_IN_ROOM + ASSERT_EXPECT_TEXT_SECOND_ENTITY_IN_ROOM, foyer.printRoomEntities());
    }

}
