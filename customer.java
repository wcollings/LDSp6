//class to hold specific customer information

import java.util.Random;

public class customer{
	int arrival, entered, processing;
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

	public int getWaitTime(int current)
	{
		return current-arrival;

	}
	public customer(int a){
		arrival=a;
		entered=0;
		Random rand= new Random();
		processing=rand.nextInt(3)+2;
	}
}