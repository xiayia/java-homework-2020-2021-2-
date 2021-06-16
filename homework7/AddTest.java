package homework7_;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author _britney_ 
 * @date 2021/5/24
 * request：
 * 加法测试
 * 使用数组列表储存答案
 * 如用户重复输入相同答案，则给出警告
 */

public class AddTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    
	    int number1 = (int) (Math.random() * 10);
	    int number2 = (int) (Math.random() * 10);

	    // Create a Scanner
	    Scanner input = new Scanner(System.in);
	    System.out.print(
	            "What is " + number1 + " + " + number2 + "? ");
	    int answer = input.nextInt();
	    list.add(answer);
	      
	    while (number1 + number2 != answer) {
	      System.out.print(
	              "Wrong. Try again. What is " + number1 + " + " + number2 + "? ");
	      answer = input.nextInt();
	      
	      if (list.contains(answer)) {
	        System.out.println("You already entered " + answer);
	      }
	      else {
	        list.add(answer);
	      }
	    }
	    
	    System.out.println("You got it!");
	  }
	}
