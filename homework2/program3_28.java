package homework2;
import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/19
* @description Chapter3 课后** 3-28
* 几何：两个圆
*/

public class program3_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		double[] Rectangle1 = new double[4];
		double[] Rectangle2 = new double[4];
		double distance1;
		double distance2;

		System.out.println("Enter r1's center x-, y-coordinates, width, and height: ");
		for (int i = 0; i < 4; ++i) {
			Rectangle1[i] = scan.nextDouble(); // 读取第一个矩形的x,y,width,height
		}

		System.out.println("Enter r2's center x-, y-coordinates, width, and height: ");
		for (int i = 0; i < 4; ++i) {
			Rectangle2[i] = scan.nextDouble(); // 读取第二个矩形的x,y,width,height
		}

		scan.close();

		distance1 = Math.abs(Rectangle1[0] - Rectangle2[0]); // x的距离
		distance2 = Math.abs(Rectangle1[1] - Rectangle2[1]); // y的距离

		if (distance1 <= (Rectangle1[2] - Rectangle2[2]) && distance2 < (Rectangle1[3] - Rectangle2[3])) {
			System.out.println("r2 is inside r1");
		} else if (distance1 <= (Rectangle1[2] + Rectangle2[2]) && distance2 <= (Rectangle1[3] + Rectangle2[3])) {
			System.out.println("r2 overlaps r1");
		} else {
			System.out.println("r2 does not overlap r1");
		}
	}

}
