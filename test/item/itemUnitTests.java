package item;

import entities.Sim;
import exceptions.InvalidEntityNameException;
import inventory.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeTest;

public class itemUnitTests {
    private Item potatoChip;
    private Sim sim;
    private Inventory inventory;

    @Before
    public void setUp() throws InvalidEntityNameException {
        try{
            potatoChip = new FoodItem("Brotato Chips", null,"A bag of potato chips",false, 1);
            inventory = new Inventory();
            inventory.addItem(potatoChip,1);
            sim = new Sim("John Doe",inventory);

        } catch(InvalidEntityNameException e){
            System.out.println(e.getMessage());
        }
        Assert.assertNotNull("Error: expected " + potatoChip.getClass().getSimpleName() + " to not be null, and it was null.",potatoChip);
    }


    @Test
    public void assertConsumableFoodItemSuccessfullyCreated() throws InvalidEntityNameException {
        Assert.assertEquals(1, this.sim.getInventorySize());

    }
}
