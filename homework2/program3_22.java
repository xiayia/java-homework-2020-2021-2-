package homework2;
import java.util.*;

/**
*
* @author _britney_
* @date 2021/4/19
* @description Chapter3 �κ�** 3-22
* �Ƿ���Բ��
*/


public class program3_22 {
	public static void main(String[] args) {
		double pointX,pointY,distance;
		
		System.out.print("Enter a point with two coordinates:");
		Scanner input = new Scanner(System.in);
		pointX = input.nextDouble();
		pointY = input.nextDouble(); 
		
		// �������꣨x,y������0,0���ľ���
		distance = Math.pow(Math.pow(pointX, 2) + Math.pow(pointY, 2), 0.5);
		
		// �����Ƿ���Բ��
		if(distance <= 10)
			System.out.println("Point " + "(" + pointX + "," + pointY + ")"
								+ " is in the circle");
		else
			System.out.println("Point " + "(" + pointX + "," + pointY + ")"
								+ " is not in the circle");
		
		input.close();
	}
}

