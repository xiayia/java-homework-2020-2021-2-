package homework3;
import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/4/26
* @description Chapter8 ¿Îºó* 8-18
*/

public class program8_18 {
	 public static void main(String args[]){
	        int[][] m = {{1,2},{3,4},{5,6},{7,8},{9,10}};
	        shuffle(m);
	        for(int i = 0; i < m.length; ++i){
	            for(int j = 0; j < m[i].length; ++j){
	                System.out.print(m[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    public static void shuffle(int[][] m){
	        int xlen = m.length;
	        int ylen = m[0].length;
	        for(int i = 0; i < xlen; ++i){
	            for(int j = 0; j < ylen; ++j){
	                int n = (int)(Math.random()*ylen);
	                int temp = m[i][n];
	                m[i][n] = m[i][j];
	                m[i][j] = temp;
	            }
	            int q = (int)(Math.random() * xlen);
	            int[] temp1 = m[q];
	            m[q] = m[i];
	            m[i] = temp1;
	        }
	    }
}
