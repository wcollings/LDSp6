public class Line{
	int customersServiced, customersBypassed, avgWaitTime, longestWaitTime;
	customer[] q;
	int size;
	public Line()
	{
		customersBypassed=0;
		customersServiced=0;
		avgWaitTime=0;
		longestWaitTime=0;
		q= new customer[4];
		for (int i=0; i < 4; ++i)
			customer[i] = new customer();
		size=0;
	}

	public void getNextCustomer(int currentTime)
	{
		customersServiced++;
		avgWaitTime=((avgWaitTime*customersServiced)+currentTime)/++customersServiced;
		if ((currentTime-q[1].arrival) >longestWaitTime)
			longestWaitTime=(currentTime-q[1].arrival);
		for (int i=0; i < size;++i)
		{
			q[i+1]=q[i];
		}
		q[size--]=new customer();
	}

	public void addCustomer(int currentTime)
	{
		if (size < 4)
		{
			q[size+1]= new customer(currentTime);
			size++;
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
}