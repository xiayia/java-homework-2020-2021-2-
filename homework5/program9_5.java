package homework5;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
*
* @author _britney_
* @date 2021/5/10
* @description Chapter9 ¿ÎºóÒ»ÐÇ 9-5
*/

public class program9_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       GregorianCalendar gregorianCalendar = new GregorianCalendar();

	        System.out.println("year: "+gregorianCalendar.get(GregorianCalendar.YEAR)+
	        " month: "+gregorianCalendar.get(GregorianCalendar.MONTH)+
	                " day "+ gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH));

	        gregorianCalendar.setTimeInMillis( 1234567898765L);
	        System.out.println("year: "+gregorianCalendar.get(GregorianCalendar.YEAR)+
	                " month: "+gregorianCalendar.get(GregorianCalendar.MONTH)+
	                " day "+ gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH));


	}

}
