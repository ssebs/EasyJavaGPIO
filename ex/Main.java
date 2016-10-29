import java.io.*;

/**
* The point of this program is to use the GPIO simply with Java. 
*/
public class Main 
{
	public static void main(String[] args) throws Exception
	{			
		GPIOUtil.setMode(1, "out");
		
		for(int i = 0; i < 68; i++)
		{
			GPIOUtil.out(1,1, 50);	
			
			GPIOUtil.out(1,0, 50);	
			
			
		}
		
	
		
		GPIOUtil.out(1,0);

		/** DON'T FORGET TO SET THE PINS BACK TO ORIGINAL VALUES **/
	}
}
