//Queue implementation. mostly self-explanatory

public class Line{
	int nextID=0;
	int customersServiced, customersBypassed, totalWaitTime, longestWaitTime;
	private customer[] q;
	int size;
	public Line()
	{
		customersBypassed=0;
		customersServiced=0;
		totalWaitTime=0;
		longestWaitTime=0;
		q= new customer[4];
		for (int i=0; i < 4; ++i)
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
		printq();
		totalWaitTime+=q[0].getWaitTime(currentTime, true);
		for (int i=0; i < size-1;++i)
		{
			q[i]=q[i+1];
		}
		if (currentTime-q[0].getWaitTime(currentTime, false) >longestWaitTime)
		longestWaitTime=q[0].getWaitTime(currentTime, false);
		--size;
	}

	public void addCustomer(int currentTime)
	{
		if (size < 4)
		{
			q[size++]= new customer(currentTime, nextID++);
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

	public void printq()
	{
		System.out.printf("The queue is: %n{");
		for (int i=0; i < size; ++i)
		{
			System.out.print(q[i].ID+" ");
		}
		System.out.println("}");
	}
}