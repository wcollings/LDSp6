import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class queue{
	
	Line line;
	int currentTime;
	int idleTime;
	PrintWriter out;

	public queue() throws Exception
	{
		out = new PrintWriter("log.txt");
		idleTime=0;
		line = new Line();
		currentTime=0;
	}

	void process(){
		Scanner pause=new Scanner(System.in);
		Random rand = new Random();
		int waitUntilNextCustomerArrives=rand.nextInt(4)+1;
		int waitUntilNextCustomerEnters=0;
		while(currentTime < 480){
			if (waitUntilNextCustomerArrives == 0)
			{
				out.println(currentTime+": customer shows up");
				line.addCustomer(currentTime);
				waitUntilNextCustomerArrives=rand.nextInt(4)+1;
			}
			if (waitUntilNextCustomerEnters == 0 )
			{
				if (!line.isEmpty())
				{					
					out.println(currentTime+": customer enters");
					line.getNextCustomer(currentTime);
					//System.out.println(currentTime+": customer enters");
					//System.out.printf("entered q at %d%n", line.get(0).arrival);
					//pause.next();
					waitUntilNextCustomerEnters=line.getNextProcessingTime();
				}
				else
				{
					idleTime++;
					waitUntilNextCustomerEnters=1; //everything gets decremented at the end. this will set it to 0
				}
			}
			
			currentTime++;
			waitUntilNextCustomerEnters--;
			waitUntilNextCustomerArrives--;
		}
		out.println(line);
		out.close();
		pause.close();
	}	

}