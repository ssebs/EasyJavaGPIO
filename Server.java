import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDateTime;


/**
 * Idea of this is to have a mobile app turn on/off gpio pins on raspberry pi where server(this) is running
 * 
 */
public class Server
{
	//TODO: Make literals in to variables.
	
	private static final int PORT = 7778;

	public static void main(String args[])
	{
		DatagramSocket sock = null;
		
		Runtime.getRuntime().addShutdownHook(new Thread()
		{
			public void run()
			{
				try
				{
					Thread.sleep(200);
					System.out.println("Shutting down ...");
					echo("Server Closed.");
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		try
		{
			//Creating a server socket, parameter is local port number
			sock = new DatagramSocket(PORT);
			//buffer to receive incoming data
			byte[] buffer = new byte[65536];
			DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

			//Wait for an incoming data
			echo("Server socket created. Waiting for incoming data...");

			//communication loop. Loop can be broken using <CTRL> + <C>, or from a client entering "/killserver"
			while (true)
			{
				byte[] data;
				String s;
				String[] parts;
				
				// Will wait for the UDP socket to get a signal, then receive the data.
				// Hopefully they don't happen at same time? Make sync
				sock.receive(incoming);
				data = incoming.getData();
				
				// Save data as String.
				// TODO: Make this not make a String every time.
				s = new String(data, 0, incoming.getLength());
				
				// TODO: Decide on architecture of string. possibly:
				//      PIN#-ON/OFF e.g.: 1-ON
				echo(s);
				
				parts = s.split("-");
				
				if (parts[1].equals("ON"))
				{
			        // GPIO Command
			        
                    
				} else if(parts[1].equals("OFF"))
				{
					// GPIO Command
			        
				} else
				{
					System.err.println("No 'ON' or 'OFF' after '-'.");
				}
				
				
			} // End communication loop
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	// Shorter version of Java's Println.
	public static void echo(String msg)
	{
		System.out.println(msg);
	}
}