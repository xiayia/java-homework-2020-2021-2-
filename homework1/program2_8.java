package homework1;
import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/12
* @description Chapter1、2 课内程序清单2-8
*/


public class program2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter purchase amount: ");
		double purchaseAmount =input.nextDouble();
		
		double tax = purchaseAmount * 0.06;
		System.out.println("Sales tax is $" + (int)(tax * 100) / 100.0);
	}

}
