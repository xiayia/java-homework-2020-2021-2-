package homework5;

/**
*
* @author _britney_
* @date 2021/5/10
* @description Chapter9 ¿ÎºóÒ»ĞÇ 9-10
*/

public class program9_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleWithPrivateDataFields myCircle = new CircleWithPrivateDataFields(1);

		// Print area for radius 1, 2, 3, 4, and 5.
		int n = 5;
		printAreas(myCircle, n);

		// See myCircle.radius and times
		System.out.println("\n" + "Radius is " + myCircle.getRadius());
		System.out.println("n is " + n);

	}

	/** Print a table of areas for radius */
	public static void printAreas(CircleWithPrivateDataFields c, int times) {
		System.out.println("Radius \t\tArea");
		while (times >= 1) {
			System.out.println(c.getRadius() + "\t\t" + c.getArea());
			c.setRadius(c.getRadius() + 1);
			times--;
		}

	}

}
