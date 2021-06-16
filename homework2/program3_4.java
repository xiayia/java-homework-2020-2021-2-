package homework2;
import java.util.Random;

/**
*
* @author _britney_
* @date 2021/4/19
* @description Chapter3 ¿Îºó** 3-4
*/


public class program3_4 {

	public static void main(String[] args) {
		Random random = new Random();
		int i = random.nextInt(12);
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		System.out.println(i + 1);
		System.out.println(months[i]);

	}
}
