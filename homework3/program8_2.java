package homework3;
import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/26
* @description Chapter8 课后* 8-2
*/


public class program8_2 {
	public static void main(String[] args) {
		int[][] array = new int[4][4];

		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < array.length; i++){
		for(int j = 0; j < array[i].length; j++){
		System.out.println("请输入第"+(i+1)+"行第"+(j+1)+"列上的元素：");
		array[i][j] = scan.nextInt();
		}
		}

		int total = 0;//作为最后存放结构的变量
		for(int i = 0; i < array.length; i++){
		for(int j = 0; j < array[i].length; j++){
		//左对角元素         右对角元素
		if(i == j || i +j == 3){
		total += array[i][j];
		}

		}
		}


		}


		} 
