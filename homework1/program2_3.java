package homework1;
import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/12
* @description Chapter1��2 ���ڳ����嵥2-3
*/


public class program2_3 {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter three numbers:");
		
		double number1 = input.nextDouble();
		double number2 = input.nextDouble();
		double number3 = input.nextDouble();
		
		double average = (number1+number2+number3)/3;
		System.out.println("The average of "+ number1 + " " + number2 
		  + " " + number3 + " is " + average);
	}

}
