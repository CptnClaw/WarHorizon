package core;


import graphics.GameFrame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game {
	
	// Receive singleton object
	public static Game getInstance()
	{
		if (game == null)
		{
			game = new Game();
		}
		return game;
	}
	
	public void start()
	{
		// Initialize game engine
		init();
		
		// Create and show window
		window = new GameFrame();
		window.setVisible(true);
		
		// Start main loop
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
	
	// Singleton object
	private static Game game = null;
	
	// Game variables
	private boolean isRunning;
	private JFrame window;
	
	// Loop control
	private final int UPDATES_PER_SECOND = 25;
	private final int SKIP_UPDATES_NANO = 1000000 / UPDATES_PER_SECOND;
	private final int MAX_FRAME_SKIP = 5;
	
	// Constructor is private - this is a singleton
	private Game()
	{

	}
	
	private void init()
	{

	}
	
	private void update()
	{
		// TODO : Do some real updating
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
			while (System.nanoTime() > nextUpdateNanos && numFrameSkip <= MAX_FRAME_SKIP)
			{
				update();
				nextUpdateNanos += SKIP_UPDATES_NANO;
				numFrameSkip++;
			}
			
			// Render with interpolation for smoother graphics when FPS exceeds UPS
			double interpolation = (double)(System.nanoTime() + SKIP_UPDATES_NANO - nextUpdateNanos) / (double)SKIP_UPDATES_NANO;
			render(interpolation);
		}
	}
	
	private void stopGameLoop()
	{
		isRunning = false;
	}

}
