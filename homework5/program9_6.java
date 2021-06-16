package homework5;

/**
*
* @author _britney_
* @date 2021/5/10
* @description Chapter9 ¿ÎºóÒ»ÐÇ 9-6
*/

public class program9_6 {
	/** The radius of the circle */
	double radius;

	/** The number of objects created */
	static int numberOfObjects = 0;

	/** Construct a circle with radius 1 */
	program9_6() {
		radius = 1;
		numberOfObjects++;
	}

	/** Construct a circle with a specified radius */
	program9_6(double newRadius) {
		radius = newRadius;
		numberOfObjects++;
	}

	/** Return numberOfObjects */
	static int getNumberOfObjects() {
		return numberOfObjects;
	}

	/** Return the area of this circle */
	double getArea() {
		return radius * radius * Math.PI;
	}

}



