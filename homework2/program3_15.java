package homework2;
import java.util.Arrays;
import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/19
* @description Chapter3 课后** 3-15
*/


public class program3_15 {

	public static void main(String[] args) {
		int lottery = (int) (Math.random() * 1000);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your lottery pick (three digits):");
		int guess = input.nextInt();
		int[] lotteryDigits = new int[3];
		int[] lotteryDigits1 = new int[3];
		int[] guessDigits = new int[3];
		int[] guessDigits1 = new int[3];
		int INDEX = 3;
		int flag = 0;
		String[] number = { "one", "two", "three" };
		input.close();
		int lottery1 = lottery;
		int guess1 = guess;

		System.out.println("The lottery number is " + String.valueOf(lottery));

		for (int i = 1; i <= INDEX; ++i) {
			lotteryDigits[INDEX - i] = lottery1 % 10;
			guessDigits[INDEX - i] = guess1 % 10;
			lottery1 /= 10;
			guess1 /= 10;
		}

		// 复制数组
		lotteryDigits1 = Arrays.copyOfRange(lotteryDigits, 0, INDEX);
		guessDigits1 = Arrays.copyOfRange(guessDigits, 0, INDEX);

		for (int i = 0; i < INDEX; ++i) {
			for (int j = 0; j < INDEX; ++j) {
				if (guessDigits1[i] == lotteryDigits1[j]) {
					lotteryDigits1[j] = -1;
					flag += 1;
					break;
				}
			}
		}

		// 排序
		Arrays.sort(lotteryDigits);
		Arrays.sort(guessDigits);

		if (guess == lottery) {
			System.out.println("Exact match: you win $10,000");
		} else if (Arrays.equals(lotteryDigits, guessDigits)) {
			System.out.println("Match all digits: you win $5,000");
		} else if (flag != 0) {
			System.out.println(String.format("Match %s digits: you win $%d,000", number[flag - 1], flag));
		} else {
			System.out.println("Sorry, no match");
		}
	}
}