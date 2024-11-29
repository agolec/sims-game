package Entity.EntityClassTests.Sim;

import exceptions.InvalidEntityNameException;
import org.junit.Test;
import org.junit.Assert;
import entities.Sim;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class entityClassTests {
    final String VALID_ENTITY_NAME = "Ted";
    private final String EXPECTED_EXCEPTION_MESSAGE_TEXT = "Error: Entity name cannot be blank, null, or empty.";
    @Test
    public void assertEntityCreatesSuccessfullyWhenAssignedValidName() throws InvalidEntityNameException {

        Sim testSim = new Sim(VALID_ENTITY_NAME);
        Assert.assertNotNull("Expected Sim object to be created, but it was null",testSim);
        assertEquals(testSim.getName(), VALID_ENTITY_NAME,testSim.getName());
        Assert.assertTrue("Expected ID to be greater than 0, but it was equal to or less than 0",testSim.getId() > 0);
}
@Test
    public void assertSimThrowsExceptionWhenNameBlank()  {
        try{
            Sim sim = new Sim("");
        } catch (InvalidEntityNameException e){
            assertEquals(EXPECTED_EXCEPTION_MESSAGE_TEXT, e.getMessage());
        }
    }
    @Test()
    public void assertSimThrowsExceptionWhenNameNull()  {
        try{
            Sim testSim = new Sim((String) null);
        } catch (Exception e){
            assertEquals(EXPECTED_EXCEPTION_MESSAGE_TEXT, e.getMessage());
        }
    }

}
