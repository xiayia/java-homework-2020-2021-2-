package homework6;
import java.util.ArrayList;
import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/5/17
* @description ≥Ã–Ú«Âµ•11-9
*/

public class DistinctNumber {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter integers (input ends with 0): ");
        int value;

        do{
            value = input.nextInt();// Read a value from the input

            if(!list.contains(value) && value != 0)
                list.add(value);// Add the value if it is not in the list
        }while(value !=0);

        System.out.print("The distinct numbers are: ");
        // Display the distinct numbers
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }
}