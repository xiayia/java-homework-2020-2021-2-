package homework2;
import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/19
* @description Chapter3 课后** 3-27
* 几何：点是否在三角形内？
*/


public class program3_27 {
	public static void main(String[] args) {
		double xCoordinate,yCoordinate;
		
		System.out.print("Enter a point's x- and y-coordinates: ");
		Scanner input = new Scanner(System.in);
		xCoordinate = input.nextDouble();
		yCoordinate = input.nextDouble();
		
		// Check if the point is in the triangle
		if(xCoordinate != 200)
		{
			if((-0.5 <= -1 * yCoordinate / (200 - xCoordinate)
				&& -1 * yCoordinate / (200 - xCoordinate) <= 0)
				&& (xCoordinate >= 0 && xCoordinate < 200))
				System.out.println("The point is in the triangle");
			else
				System.out.println("The point is not in the triangle");
		}
		else
		{
			if(yCoordinate != 0)
				System.out.println("The point is not in the triangle");
			else
				System.out.println("The point is in the triangle");
		}
		
		input.close();
	}
}
