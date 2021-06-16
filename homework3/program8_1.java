package homework3;
import java.util.Scanner;
/**
*
* @author _britney_
* @date 2021/4/26
* @description Chapter8 课后* 8-1
* 先输入一个3*4的矩阵，建立列索引，然后将每列数字相加结果赋给sum,最后返回sum即可。
*/

public class program8_1 {
    public static void main(String[] args) {

	    Scanner input = new Scanner(System.in);
	    System.out.println("Enter a 3-by-4 matrix row by row");
	    double[][] m = new double[3][4];
	    for (int i = 0; i < m.length; i++) {
		for (int j = 0; j < m[0].length; j++) {
			m[i][j] = input.nextDouble();
		}
	    }
	    for (int i = 0; i < 4; i++) {
		    System.out.println("Sum of the elements at column " + i + " is " + sum(m, i));
	    }
    }

    public static double sum(double[][] m, int columnIndex) {
	    double sum = 0;
	    for (int j = 0; j < m.length; j++) {
	    	sum += m[j][columnIndex];

	    }
	    return sum;
    }

}
