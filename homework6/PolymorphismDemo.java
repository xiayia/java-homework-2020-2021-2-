package homework6;
/**
*
* @author _britney_
* @date 2021/5/17
* @description ≥Ã–Ú«Âµ•11-5
*/

public class PolymorphismDemo {
    /** Main method */
    public static void main(String[] args) {
        // Display circle and rectangle properties
        displayObject(new CircleFromSimpleGeometricObject
                (1, "red", false));
        displayObject(new RectangleFromSimpleGeometricObject
                (1, 1, "black", true));
    }

    /** Display geometric object properties */
    public static void displayObject(SimpleGeometricObject object) {
        System.out.println("Created on " + object.getDateCreated() +
          " Color is " + object.getColor());

    }
}