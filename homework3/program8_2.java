package homework3;
import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/26
* @description Chapter8 �κ�* 8-2
*/


public class program8_2 {
	public static void main(String[] args) {
		int[][] array = new int[4][4];

		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < array.length; i++){
		for(int j = 0; j < array[i].length; j++){
		System.out.println("�������"+(i+1)+"�е�"+(j+1)+"���ϵ�Ԫ�أ�");
		array[i][j] = scan.nextInt();
		}
		}

		int total = 0;//��Ϊ����Žṹ�ı���
		for(int i = 0; i < array.length; i++){
		for(int j = 0; j < array[i].length; j++){
		//��Խ�Ԫ��         �ҶԽ�Ԫ��
		if(i == j || i +j == 3){
		total += array[i][j];
		}

		}
		}


		}


		} 
