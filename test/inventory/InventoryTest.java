package inventory;

import entities.Sim;
import exceptions.InvalidEntityNameException;
import item.Appliance;
import item.Item;
import item.food.FoodItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class InventoryTest {
    private Sim testSim;
    private ArrayList<Item> itemsSim1;

    @Before
    public void setUp() throws InvalidEntityNameException {
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
        Assert.assertNotNull("Failed: Sim should be created successfully at end of seUp(), and not-null, but it was found to be null.",testSim);
    }

    @Test
    public void testInventoryStartsEmpty() throws InvalidEntityNameException {

        Assert.assertEquals("Failed: Inventory on " + this.testSim.getTypeName().toUpperCase() + " " + this.testSim.getName() +
                                    "  should be size 0 when Sim is created.", this.testSim.getInventory().getInventorySize(), 0);


    }

    @Test
    public void testInventoryIncreasesWhenItemAdded() {
        //Adding inventory to sim.
        this.testSim.getInventory().addItem(this.itemsSim1.getFirst());
        Assert.assertEquals("Failed: Inventory should be size 1, after one item added following Inventory initialization.",1,this.testSim.getInventory().getInventorySize());

        System.out.println(this.testSim.getInventory().toString());
    }
}
