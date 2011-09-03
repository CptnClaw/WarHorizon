package core;

import javax.swing.SwingUtilities;

public class Execute 
{

	// Main
	public static void main(String[] args) 
	{
		// Start the game in a different thread than UI
		SwingUtilities.invokeLater(new Runnable() 
		{
	         @Override
	         public void run() 
	         {
	        	 Game game = Game.getInstance();
	        	 game.start();
	         }
		});
	}
	
}
