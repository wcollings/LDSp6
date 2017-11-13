//class to hold specific customer information

import java.util.Random;

public class customer{
	int arrival, entered, processing, ID;
	public customer(){
	}

	public void setEnterTime(int a)
	{
		entered=a;
	}

	public int getWaitTime()
	{
		return entered-arrival;
	}

	public int getWaitTime(int current, boolean print)
	{
		//if (print)
		//System.out.printf("#%d pulled in at %d, entered at %d, wait time was %d%n",ID, arrival, current, current-arrival);		
		return current-arrival;

	}
	public customer(int a){
		arrival=a;
		entered=0;
		Random rand= new Random();
		processing=rand.nextInt(3)+2;
	}

	public customer(int a, int ID){
		this.ID=ID;
		arrival=a;
		entered=0;
		Random rand= new Random();
		processing=rand.nextInt(3)+2;
	}
}