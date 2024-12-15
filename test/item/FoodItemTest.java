package item;

import entities.Sim;
import exceptions.InvalidEntityNameException;
import item.food.FoodItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FoodItemTest {
    private Sim testSim;
    private ArrayList<Item> itemsSim1;
    @Before
    public void setup(){
            this.testSim = null;
            this.itemsSim1 = new ArrayList<>();
            try {
                this.testSim = new Sim("john");
                this.itemsSim1.add(new FoodItem("cookies",null,"cookies", false,1,1));
                this.itemsSim1.add(new FoodItem("Cookie tin",null,"cookies in a tin",false,5,1));
                this.itemsSim1.add(new FoodItem("chips",null,"lays",false,1,1));
                this.itemsSim1.add(new Appliance("trash compactor",null,"Smash-o-trash compator",false));
            } catch (InvalidEntityNameException e) {
                System.out.println("Error: Failed to create sim: " + e.getMessage());

            }
            Assert.assertNotNull("Failed: Sim should be created successfully at end of seUp(), and not-null, but it was found to be null.",testSim);
        }

    @Test
    public void energyGivenToSimShouldAddEnergyOnSim(){
        final String HUNGER_NEED = "Hunger";
        final int STEPS = 5;

        for(Item item: this.itemsSim1){
            this.testSim.getInventory().addItem(item);
        }
        Assert.assertEquals(100,this.testSim.getNeed("Hunger").getValue());
        this.testSim.decayNeed("Hunger",this.testSim.getNeed("Hunger").getDecayRate(),10);
        Assert.assertEquals(90,this.testSim.getNeed("Hunger").getValue());
        this.testSim.consume(this.testSim.getInventory().getItemByIndex(this.testSim.getInventory().getItemIndex("cookies")));
        Assert.assertEquals(91,this.testSim.getNeed("Hunger").getValue());

    }
}
