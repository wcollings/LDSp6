import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

//Implements the running algorithm

public class queue{
	
	static Line line;
	static int idleTime;
	static PrintWriter out;

	public queue() throws Exception
	{
	}

	public static void main(String[] args)throws Exception
	{
		out = new PrintWriter("log.txt");
		idleTime=0;
		line = new Line();
		Scanner pause=new Scanner(System.in);
		Random rand = new Random();
		int waitUntilNextCustomerArrives=rand.nextInt(4)+1;
		int waitUntilNextCustomerEnters=0;
		for (int currentTime=0; currentTime < 480; ++currentTime){
			if (waitUntilNextCustomerArrives == currentTime)
			{
				out.println(currentTime+": customer shows up");
				line.addCustomer(currentTime);
				waitUntilNextCustomerArrives=currentTime+(rand.nextInt(4)+1);
			}
			if (waitUntilNextCustomerEnters == currentTime )
			{
				if (!line.isEmpty())
				{
					waitUntilNextCustomerEnters=currentTime+line.getNextProcessingTime();
					out.println(currentTime+": customer enters");
					line.getNextCustomer(currentTime);
				}
				else
				{
					idleTime++;
					waitUntilNextCustomerEnters=currentTime+1;
				}
			}
		}
		out.println(line);
		out.close();
		pause.close();
	}	

}