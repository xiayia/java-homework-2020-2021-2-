package homework7_;
import java.util.*;

/**
 * @author _britney_ 
 * @date 2021/5/24
 * request：
 * 提示用户输入一个整数m
 * 找到最小的整数n
 * 使得m*n是一个完全平方
 */

public class PerfectSquare {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter an integer m: ");
        int n=input.nextInt();
        int flag=n;
        int i=2;
        int m=1;
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Integer> list1=new ArrayList<Integer>();
        int []a=new int[1000];
        while(n!=1) {
            if(n%i==0) {
                list.add(i);
                n=n/i;
                a[i]++;
            }
            else
                i++;    

        }
        for(int j=0;j<1000;j++)
        {
            if(a[j]!=0&&(a[j]%2==1))
                m=m*j;
        }
        System.out.print("The smallest number n for m*n to be a perfect is ");
        System.out.println(m);
        System.out.print("m*n is ");
        System.out.println(m*flag);
    }

}


