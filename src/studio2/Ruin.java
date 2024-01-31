package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("The amount of money you started with: ");
		double startAmount = in.nextDouble();
		System.out.print("The win probability: ");
		double winChance = in.nextDouble();
		System.out.print("The amount of money to have a successful day: ");
		double winLimit = in.nextDouble();
		System.out.print("The number of days you want to simulate: ");
		double totalSimulations = in.nextDouble();
		double expRuinRate; 
		int numRuin = 0;
		if (winChance == 0.5)
		{
			expRuinRate = (1 - (startAmount/winLimit));
		}
		else
		{
			double a = (1 - winChance) / winChance;
			expRuinRate = (Math.pow(a,startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a, winLimit)); 
		}
		
		for(int i = 0; i< totalSimulations; i ++)
		{
		double playAmount = startAmount;
		int amtPlays = 0;
		while (!(playAmount == winLimit) && !(playAmount==0))
		{
			double fate = (double)( Math.random()*100)/100.0;
			
			
			if (fate < winChance)
			{
				playAmount ++;
			}
			else 
			{
				playAmount --;
			}
			amtPlays ++;

		}
		System.out.print("Simulation Day " + (i+1) + ": ");
		
	if (playAmount == 0)
	{
		System.out.print("Ruin");
		numRuin++;
	}
	if (playAmount ==winLimit)
	{
		System.out.print("Success");
	}
	System.out.println(" out of " + amtPlays + " plays.");	
		}
		double ruinRate = (double)(numRuin / totalSimulations);
		System.out.println("Ruin rate from simulation: " + ruinRate);
		System.out.println("Expected ruin rate: " + expRuinRate);
	}

}
