package utils;

import entities.Entity;
import entities.Sim;

/**
 * EntityUtils exists to help code reasability and determine things such as whether a certain entity exists.
 */
public class EntityUtils {
    public static boolean entityExists(Entity entity) {
        return entity != null;
    }
}
