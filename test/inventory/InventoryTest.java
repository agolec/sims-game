package inventory;

import entities.Sim;
import exceptions.InvalidEntityNameException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.Failure;
import org.testng.Assert;

public class InventoryTest {
    private Sim testSim;
    private Inventory inventory;
    @Before
    public void setUp(){
        this.inventory = new Inventory();
        this.testSim = null;
        try{
            this.testSim = new Sim("john",inventory);
        } catch (InvalidEntityNameException e){
            System.out.println("Errror: Failed to create sim: " + e.getMessage());

        }
    }
    @Test
    public void inventoryShouldBeInitializedToZero() {

        Assert.assertNotNull(testSim,"Sim should be created successfully");
        Assert.assertEquals(this.testSim.getInventorySize(),0,"Inventory should be size 0 when Sim is created.");
    }
}
