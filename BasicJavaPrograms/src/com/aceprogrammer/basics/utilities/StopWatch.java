package com.aceprogrammer.basics.utilities;

/**
 * @author Salman Shaikh
 *
 */
public class StopWatch {

	private long startTime;
	
	private long stopTime;
	
	private long elapsedTime;
	
	/**
	 * This method records the start time.
	 */
	public void start()
	{
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * This method records the stop time.
	 */
	public void stop()
	{
		stopTime = System.currentTimeMillis();
	}
		
	/**
	 * @return elapsedTime i.e. time between start time and stop time.
	 */
	public long getElapsedTime()
	{
		elapsedTime = (stopTime - startTime)/ 1000;
		return elapsedTime;
	}
	
}
