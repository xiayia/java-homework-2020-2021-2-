package homework9;
import java.util.Scanner; 

/**
 * @author _britney_ 
 * @date 2021/6/7
 * @description Chapter12 ≥Ã–Ú«Âµ•12-1
 */

public class Quotient {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    // Prompt the user to enter two integers
    System.out.print("Enter two integers: ");
    int number1 = input.nextInt();
    int number2 = input.nextInt();
    
    System.out.println(number1 + " / " + number2 + " is " +
      (number1 / number2));
  }
}
