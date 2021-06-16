package homework6;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author _britney_
* @date 2021/5/17
* @description ≥Ã–Ú«Âµ•11-8
*/

public class TestArrayList {
    public static void main(String[] args) {
        // Creat a list to store cities
        List<String> cityList = new ArrayList<String>();

        // Add some cities in the list
        cityList.add("London");
        // cityList now contains [London]
        cityList.add("Denver");
        // cityList now contains [London, Delver]
        cityList.add("Paris");
        // cityList now contains [London, Denver, Paris]
        cityList.add("Miami");
        // cityList now contains [London, Denver, Paris, Miami]
        cityList.add("Seoul");
        // contains [London, Denver, Paris, Miami, Seoul]
        cityList.add("Tokyo");
        // contains [London, Denver, Paris, Miami, Seoul, Tokyo]

        System.out.println("List size? " + cityList.size());
        System.out.println("Is Miami in the list? " +
          cityList.contains("Miami"));
        System.out.println("The location of Denver in the list? "
          + cityList.indexOf("Denver"));
        System.out.println("Is the list empty? " +
          cityList.isEmpty());// Print false

        // Insert a new city at index 2
        cityList.add(2, "Xian");
        // Contains [London, Denver, Xian, Paris, Miami, Seoul, Tokyol]

        // Remove a city from the list
        cityList.remove("Miami");
        // Contains [London, Denver, Xian, Paris, Seoul, Tokyol]

        // Remove a city at index 1
        cityList.remove(1);
        // Contains [London, Xian, Paris, Seoul, Tokyol]

        // Display the contents in the list
        System.out.println(cityList.toString());

        // Display the contents in the list in reverse order
        for (int i = cityList.size() - 1; i >= 0; i--)
            System.out.print(cityList.get(i) + " ");
        System.out.println();

        //Creat a list to store two circles
        ArrayList<CircleFromSimpleGeometricObject> list
          = new ArrayList<>();

        // Add two circles
        list.add(new CircleFromSimpleGeometricObject(2));
        list.add(new CircleFromSimpleGeometricObject(3));

        // Display the area of the first circle in the list
        System.out.println("The area og the circle? " +
          list.get(0).getArea());
    }
}
