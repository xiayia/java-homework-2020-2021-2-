package homework4;

/**
*
* @author _britney_
* @date 2021/5/3
* @description Chapter9 ≥Ã–Ú«Âµ• 9-9
*/

public class TestCircleWithPrivateDataFields {
	/** Main method */
	public static void main(String[] args) {
		// Create a circle with radius 5.0
		CircleWithPrivateDataFields myCircle = new CircleWithPrivateDataFields();
		System.out.println("The area of the circle of radius " + myCircle.getRadius() + " is " + myCircle.getArea());

		// Increase myCircle's radius by 10%
		myCircle.setRadius(myCircle.getRadius() * 1.1);
		System.out.println("The area of the circle of radius " + myCircle.getRadius() + " is " + myCircle.getArea());

		System.out.println("The number of objectts created is " + CircleWithPrivateDataFields.getNumberOfObjects());

		
	}

}


