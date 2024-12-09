package inventory;

import entities.Sim;
import exceptions.InvalidEntityNameException;
import item.Appliance;
import item.Item;
import item.ItemType;
import item.food.FoodItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class InventoryTest {
    private Sim testSim;
    private Inventory inventory;
    private ArrayList<Item> itemsSim1;

    @Before
    public void setUp() throws InvalidEntityNameException {
        this.inventory = new Inventory();
        this.testSim = null;
        this.itemsSim1 = new ArrayList<>();
        try {
            this.testSim = new Sim("john");
            this.itemsSim1.add(new FoodItem("beans",null,"beans can", false,1,1));
            this.itemsSim1.add(new FoodItem("chips",null,"lays",false,1,1));
            this.itemsSim1.add(new Appliance("trash compactor",null,"Smash-o-trash compator",false));
        } catch (InvalidEntityNameException e) {
            System.out.println("Error: Failed to create sim: " + e.getMessage());

        }
    }

    @Test
    public void testInventoryStartsEmpty() throws InvalidEntityNameException {

        Assert.assertNotNull("Sim should be created successfully",testSim);
        Assert.assertEquals("Inventory should be size 0 when Sim is created.",this.testSim.getInventory().getInventorySize(), 0);
        for(int i = 0; i < this.itemsSim1.size(); i++){
            System.out.println((i+1) + " " + this.itemsSim1.get(i).getName());
        }
        this.testSim.getInventory().addItem(this.itemsSim1.get(0));
        Assert.assertEquals("Failed: Inventory should be size 1, after one item added following Inventory initialization.",1,this.testSim.getInventory().getInventorySize());

        System.out.println(this.testSim.getInventory().toString());

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
