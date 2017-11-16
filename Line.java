//Queue implementation. mostly self-explanatory

public class Line{
	int customersServiced, customersBypassed, totalWaitTime, longestWaitTime;
	private customer[] q;
	int size;
	final int MAXSIZE=8;
	public Line()
	{
		customersBypassed=0;
		customersServiced=0;
		totalWaitTime=0;
		longestWaitTime=0;
		q= new customer[MAXSIZE];
		for (int i=0; i < MAXSIZE; ++i)
			q[i] = new customer();
		size=0;
	}

	public customer get(int index)
	{
		return q[index];
	}

	public void getNextCustomer(int currentTime)
	{
		customersServiced++;
		totalWaitTime+=q[0].getWaitTime(currentTime);
		for (int i=0; i < size-1;++i)
		{
			q[i]=q[i+1];
		}
		if (currentTime-q[0].getWaitTime(currentTime) >longestWaitTime)
		longestWaitTime=q[0].getWaitTime(currentTime);
		--size;
	}

	public void addCustomer(int currentTime)
	{
		if (size < MAXSIZE)
		{
			q[size++]= new customer(currentTime);
		}
		else customersBypassed++;
	}

	public int getNextProcessingTime()
	{
		return q[0].processing;
	}

	public boolean isEmpty(){
		return (size ==0 ? true : false);
	}

	public String toString()
	{
		String output="FINAL REPORT:\n";
		output+=customersServiced+" Customers served\n";
		output+=customersBypassed+" customers bypassed\n";
		output+=(totalWaitTime/customersServiced)+"m was the avg wait time\n";

		return output;
	}

	public int size()
	{
		return size;
	}
}