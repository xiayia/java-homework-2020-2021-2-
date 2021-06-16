package homework5;
import java.util.Random;

/**
*
* @author _britney_
* @date 2021/5/10
* @description Chapter9 ¿ÎºóÒ»ÐÇ 9-4
*/


public class program9_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random randomnumbers=new Random(1000);
        int tot=50;
        while(tot>0)
        {
            System.out.println(randomnumbers.nextInt(100));
            tot--;
        }
	}

}
