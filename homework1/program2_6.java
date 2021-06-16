package homework1;

import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/12
* @description Chapter1、2 课内程序清单2-6
*/


public class program2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a dagree in Fahrenheit:");
		double fahrenheit = input.nextDouble();
		double celsius = (5.0/9) * (fahrenheit - 32);
		System.out.println("Fahrenheit " + fahrenheit + " is " +
		  celsius + " in Celsius");
	}

}
