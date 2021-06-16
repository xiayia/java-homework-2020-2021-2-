package homework4;

/**
*
* @author _britney_
* @date 2021/5/3
* @description Chapter9 程序清单 9-4
*/

public class TestTV {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TV tv1 = new TV();
		tv1.turnOn();
		tv1.setChannel(30);
		tv1.setVolumelevel(3);
		
		TV tv2 = new TV();
		tv2.turnOn();
		tv2.channelUP();
		tv2.channelUP();
		tv2.volumeUp();
		
		System.out.println("tv1's channel is " + tv1.channel
		+ " and volumn level is " + tv1.volumelevel);
		System.out.println("tv2's channel is " + tv2.channel
		+ " and volumn level is " + tv2.volumelevel);		
	}

}
