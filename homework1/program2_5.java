package homework1;

import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/12
* @description Chapter1、2 课内程序清单2-5
*/


public class program2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer for seconds:");
		int seconds = input.nextInt();
		int minutes = seconds / 60;
		int remainingSeconds = seconds % 60;
		System.out.println(seconds + " seconds is " + minutes +
		  "minutes and " + remainingSeconds + " seconds");
	}

}
