package core;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game {
	
	// Game variables
	private boolean isRunning;
	private JFrame window;
	
	// Loop control
	final int updatesPerSecond = 25;
	final int skipUpdateNanos = 1000000 / updatesPerSecond;
	final int maxFrameSkip = 5;
	
	public Game()
	{
		init();
		
		// TODO Create a real game window, derived from JFrame
		window = new JFrame("War Horizon");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.setVisible(true);
		
		Thread gameLoop = new Thread()
		{
			@Override
			public void run()
			{
				startGameLoop();
			}
		};
		gameLoop.start();
	}
	
	private void init()
	{

	}
	
	private void update()
	{
		// TODO Do some real updating
		try 
		{
			Thread.sleep(100);
		} 
		catch (InterruptedException e) 
		{
			
		}
	}
	
	private void render(double interpolation)
	{
		window.repaint();
	}
	
	private void startGameLoop()
	{
		int numFrameSkip;
		long nextUpdateNanos = System.nanoTime();
		isRunning = true;
		while (isRunning)
		{
			// Update at a regular interval
			numFrameSkip = 0;
			while (System.nanoTime() > nextUpdateNanos && numFrameSkip <= maxFrameSkip)
			{
				update();
				nextUpdateNanos += skipUpdateNanos;
				numFrameSkip++;
			}
			
			// Render with interpolation for smoother graphics when FPS exceeds UPS
			double interpolation = (double)(System.nanoTime() + skipUpdateNanos - nextUpdateNanos) / (double)skipUpdateNanos;
			render(interpolation);
		}
	}
	
	private void stopGameLoop()
	{
		isRunning = false;
	}

	// Main
	public static void main(String[] args) 
	{
		// Start the game in a different thread than UI
		SwingUtilities.invokeLater(new Runnable() 
		{
	         @Override
	         public void run() 
	         {
	            Game warHorizon = new Game();
	         }
		});
	}

}
