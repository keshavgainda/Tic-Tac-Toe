
import java.util.Scanner;

public class TicTacdemo {
	
	public static void main(String[] args)
	{
	   
		Scanner in = new Scanner(System.in);
      
		int player = 2;
      
		boolean onSwitch = true;

		PlayTicTac ticTacToe = new PlayTicTac();

		ticTacToe.drawBoard();
		while (!ticTacToe.win(player))
		{
			if(onSwitch == true) 
			{
				if (player == 1)
				{
					player = 2;
				}	
				else
				{
					player = 1;
				}
			}

			if (player ==1) 
			{
           		System.out.print("Player " + player + " (X) choose a row and column(0,1,2): ");
			}
			else 
			{
				System.out.print("Player " + player + " (O) choose a row and column(0,1,2): ");
			}
			
			int row = in.nextInt();
			int column = in.nextInt();
         
			try 
			{
				ticTacToe.choose(row, column, player);
				ticTacToe.drawBoard();
				onSwitch = true;
			} 
			
			catch (UnavailableCellException e) 
			{
				System.out.println("Position Occupied. Try again.");
				onSwitch = false;
			}
			
			catch (ArrayIndexOutOfBoundsException e) 
			{
				System.out.println("Invalid Position. Try again.");
				onSwitch = false;
			}
		}
		System.out.println("Player " + player + " wins!");
   	}

}



