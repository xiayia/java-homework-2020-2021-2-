package homework1;

/**
*
* @author _britney_
* @date 2021/4/12
* @description Chapter1��2 ���ڳ����嵥2-7
*/


public class program2_7 {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		long totalMilliseconds = System.currentTimeMillis();
		long totalSeconds = totalMilliseconds / 1000;
		long currentSeconds = totalSeconds % 60;
		long totalMinutes = totalSeconds / 60;
		long currentMinute = totalMinutes % 60;
		long totalHours = totalMinutes / 60;
		long currentHour = totalHours % 24;
		System.out.println("Current time is " + currentHour + ":"
		  + currentMinute + ":" + currentSeconds + " GMT");
	}

}
