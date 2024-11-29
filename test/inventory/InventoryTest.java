package inventory;

import entities.Sim;
import exceptions.InvalidEntityNameException;
import item.Item;
import item.ItemType;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class InventoryTest {
    private Sim testSim;
    private Inventory inventory;

    @Before
    public void setUp() {
        this.inventory = new Inventory();
        this.testSim = null;
        try {
            this.testSim = new Sim("john", inventory);
        } catch (InvalidEntityNameException e) {
            System.out.println("Error: Failed to create sim: " + e.getMessage());

        }
    }

    @Test
    public void testInventoryStartsEmpty() {

        Assert.assertNotNull("Sim should be created successfully",testSim);
        Assert.assertEquals("Inventory should be size 0 when Sim is created.",this.testSim.getInventorySize(), 0);
    }

    @Test
    public void testInventoryIncreasesWhenItemAdded() {
        /*Assert.assertNotNull(testSim,"Sim should be created successfully");

        Item dummyItem = new CoffAddeeMaker("Mr. Regular-Joe Coffee", ItemType.APPLIANCE,this.testSim,50.0,"Do you have a Sim who needs to burn the midnight oil? " +
                "Keep them pumped full of coffee, and they'll spend less time " +
                "napping and more time amusing you.",false);
        Assert.assertEquals(this.testSim.getInventorySize(),0,"Inventory should be size 0 when Sim is created.");
    }*/
    }
}
