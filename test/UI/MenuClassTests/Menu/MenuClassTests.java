package UI.MenuClassTests.Menu;

import UI.Menu;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuClassTests {
    @Test
    public void assertMenuLengthShouldEqualNumberOfOptions(){
        List<String> neighborhoodMenuOptions = Arrays.asList("Create A Sim", "Evict","Exit Game");
        Menu neighborhoodMenu = new Menu(neighborhoodMenuOptions);
        Assert.assertEquals(neighborhoodMenuOptions,neighborhoodMenu.getOptions());
    }
    @Test
    public void assertMenuEmpty(){
        Menu menu = new Menu(new ArrayList<>());
        Assert.assertTrue("Failure: Menu must be empty.",menu.getOptions().isEmpty());
    }
}
