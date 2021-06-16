package homework2;
import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/19
* @description Chapter3 课后** 3-23
* 检查点是否在矩形内
*/


public class program3_23 {

	public static void main(String[] args) {
		double pointX,pointY;
		
		System.out.print("Enter a point with two coordinates:");
		Scanner input = new Scanner(System.in);
		pointX = input.nextDouble();
		pointY = input.nextDouble();
		
		// 检查点是否在矩形内
		if((pointX >= -5 && pointX <= 5) && (pointY >= -2.5 && pointY <= 2.5))
			System.out.println("Point " + "(" + pointX + "," + pointY + ")"
								+ " is in the rectangle");
		else
			System.out.println("Point " + "(" + pointX + "," + pointY + ")"
								+ " is not in the rectangle");

		input.close();
	}
}

