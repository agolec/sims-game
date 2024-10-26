package Entity.EntityClassTests.Sim;

import exceptions.InvalidEntityNameException;
import org.testng.Assert;
import org.testng.annotations.Test;
import entities.Sim;

public class entityClassTests {
    final String VALID_ENTITY_NAME = "Ted";
    final String EMPTY_STRING_NAME = "";
    final String NULL_STRING = null;
    final int ZERO = 0;
    @Test
    public void assertEntityCreatesSuccessfullyWhenAssignedValidName() throws InvalidEntityNameException {

        Sim testSim = new Sim(VALID_ENTITY_NAME);
        Assert.assertNotNull(testSim,"Excpected Sim object to be created, but it was null");
        Assert.assertEquals(testSim.getName(), VALID_ENTITY_NAME,"Expected Sim objectt to have name \'" + VALID_ENTITY_NAME +"\'. " +
                "\nActual Name: " + testSim.getName());
        Assert.assertTrue(testSim.getId() > ZERO,"Expected ID to be greater than 0, but it was equal to or less than 0");
    }
@Test(expectedExceptions = InvalidEntityNameException.class,expectedExceptionsMessageRegExp = "Error: Entity name cannot be blank or empty.")
    public void assertSimThrowsExceptionWhenNameBlank() throws InvalidEntityNameException {
        Sim testSim = new Sim(EMPTY_STRING_NAME);
    }
    @Test(expectedExceptions = InvalidEntityNameException.class,expectedExceptionsMessageRegExp = "Error: Entity name cannot be blank or empty.")
    public void assertSimThrowsExceptionWhenNameNull() throws InvalidEntityNameException {
        Sim testSim = new Sim(NULL_STRING);
    }

}
