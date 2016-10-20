import java.io.*;

/**
* The point of this program is to use the GPIO simply with Java. 
*/
public class Main 
{
	private static final int LED_PIN = 1;
	private static final int ON = 1;
	private static final int OFF = 0;
	
	public static void main(String[] args) throws Exception
	{			
		//setMode(LED_PIN, "out");
			
		int temp =  GPIOUtil.in(LED_PIN);
	
		if( temp == ON ) {
			GPIOUtil.out(LED_PIN, OFF);
		} else {
			for (int i = 0; i < 50; i++) {
				GPIOUtil.out(LED_PIN,ON,50);
				GPIOUtil.out(LED_PIN,OFF,50);
			}		
		}
		
				
		GPIOUtil.out(LED_PIN, OFF);

		/** DON'T FORGET TO SET THE PINS BACK TO ORIGINAL VALUES **/
	}
}
