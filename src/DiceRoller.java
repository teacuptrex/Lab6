import java.util.Random;
import java.util.Scanner;

public class DiceRoller {
	
	private static Scanner scnr = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		boolean playing = true;
		do
		{
		System.out.println("How many sides do your dice have?");
		int diceSize = scnr.nextInt();
		scnr.nextLine();
		
		if (inputYes(scnr, "Would you like to roll the dice?"))
		{
			System.out.print(generateRandomDieRoll(diceSize) + "\r\n");
			System.out.print(generateRandomDieRoll(diceSize) + "\r\n");
			playing = inputYes(scnr, "Would you like to play again?");
		}
		else
		{
			System.out.println("Goodbye!");
			break;
		}
		} while (playing);
	}
	
	public static int generateRandomDieRoll (int diceSize)
	{
		Random rand = new Random();
		int diceRoll = rand.nextInt(diceSize);	      
		diceRoll += 1; 
		return diceRoll;
	}

	public static boolean inputYes (Scanner scnr, String prompt)
	{
		System.out.println(prompt);
		String input = scnr.nextLine().toLowerCase();
		boolean valid = false;	
		boolean yesNo = false;
		while (valid == false)
		{
						
				if (input.equals("yes") || input.equals("yeah") || input.equals("y") || input.equals("yep"))
				{
					yesNo = true;
					break;
				}
				else if (input.equals("no") || input.equals("nada") || input.equals("n") || input.equals("nope"))
				{
					yesNo = false;
					break;
				} 		
				else
				{
					valid = false;
					System.out.println("Your answer was invalid.");
					System.out.println(prompt);
					input = scnr.nextLine().toLowerCase();
				}
		}
		return yesNo;
	}
}