package utils;

import entities.Sim;

/**
 * SimUtils is a utility to help readability with code that checks for existence of sims and other functions.
 */
public class SimUtils {
    public static boolean simExists(Sim sim){
        return sim != null;
    }
}
