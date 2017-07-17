package com.aceprogrammer.basics.Utilities;

public class StopWatch {

	private long startTime;
	
	private long stopTime;
	
	private long elapsedTime;
	
	public void start()
	{
		startTime = System.currentTimeMillis();
	}
	
	public void stop()
	{
		stopTime = System.currentTimeMillis();
	}
	
	// returns time in seconds
	public long getElapsedTime()
	{
		elapsedTime = (stopTime - startTime)/ 1000;
		return elapsedTime;
	}
	
}
