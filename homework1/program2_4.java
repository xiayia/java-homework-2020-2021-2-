package homework1;

import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/12
* @description Chapter1��2 ���ڳ����嵥2-4
*/


public class program2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double PI = 3.14159;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number for radius:");
		double radius = input.nextDouble();
		double area = radius*radius*PI;
		System.out.println("The area for the circle of radius " + 
		  radius + " is " + area);
	}

}
