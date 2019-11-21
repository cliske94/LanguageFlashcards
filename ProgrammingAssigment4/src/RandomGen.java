

/*
 * Programmer: Cody Liske
 * Last Updated: 3/26/2019
 * Version: 1.0
 * 
 * This class is a random generator for use with doubles and integers
 */

public class RandomGen {
	private double lowBound, highBound;
	
	public RandomGen()
	{
		// Default set up is for dice
		lowBound = 1;
		highBound = 6;
	}
	
	public double getLowBound()
	{
		return lowBound;
	}
	
	public void setLowBound(double number)
	{
		lowBound = number;
	}
	
	public double getHighBound()
	{
		return highBound;
	}
	
	public void setHighBound(double number)
	{
		highBound = number;
	}
	
	public int getRandomI()
	{
		int rando = (int) (Math.random() * (highBound - lowBound) + 1);
		return rando;
	}
	
	public double getRandomD()
	{
		double rando = Math.random() * (highBound - lowBound) + 1;
		return rando;
	}
}
