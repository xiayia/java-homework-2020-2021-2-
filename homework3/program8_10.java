package homework3;

/**
*
* @author _britney_
* @date 2021/4/26
* @description Chapter8 ¿Îºó* 8-10
*/


public class program8_10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[4][4];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = (int) (Math.random() * 2);
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		System.out.println("The largest row index:" + max(a, true));
		System.out.println("the largest column index:" + max(a, false));

	}
	private static int max(int[][] array, boolean rowCol) {
		int max;
		int temp = 0, cou = -1;
		for (int i = 0; i < array.length; i++) {
			max = 0;
			for (int j = 0; j < array[i].length; j++) {
				int index = (rowCol) ? array[i][j] : array[j][i];
				if (index == 1)
					max++;
			}
			if (temp < max) {
				temp = max;
				cou = i;
			}
		}
		return cou;
	}
}
