import java.util.Random;

public class customer{
	int arrival, entered, processing;
	boolean enqueued;
	public customer(){
		enqueued=false;
	}

	public setEnterTime(int a)
	{
		entered=a;
	}

	public getWaitTime()
	{
		return entered-arrival;
	}
	public customer(int a){
		arrival=a;
		entered=0;
		Random rand= new Random();
		processing=rand.nextInt(3)+2;
		enqueued=true;
	}
	boolean exists()
	{
		return enqueued;
	}
}