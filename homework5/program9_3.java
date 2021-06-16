package homework5;
import java.util.Date;

/**
*
* @author _britney_
* @date 2021/5/10
* @description Chapter9 ¿ÎºóÒ»ÐÇ 9-3
*/


public class program9_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d=new Date();
        long a=10000;
        int tot=8;
        while(tot>0)
        {
            d.setTime(a);
            System.out.println(a+"->"+d.toString());
            a*=10;
            tot--;
        }

	}

}
