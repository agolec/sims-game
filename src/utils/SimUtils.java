package utils;

import entities.Sim;
import item.Item;

/**
 * SimUtils is a utility to help readability with code that checks for existence of sims and other functions.
 */
public class SimUtils {
    public static boolean simExists(Sim sim){
        return sim != null;
    }
    public static String getOwnerString(Item item) {
        return item.hasOwner() ? "Owner: " + item.getOwner().toString() + "\n" : "Owner: none \n";
    }
}
