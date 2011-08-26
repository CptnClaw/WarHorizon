package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame 
{
	
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 600;
	
	public class GamePanel extends JPanel
	{
		public GamePanel()
		{
			this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			this.setBackground(Color.BLUE);
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponents(g);
		}
	}
	
	private GamePanel panel;
	
	public GameWindow()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		panel = new GamePanel();
		this.setContentPane(panel);
		this.pack();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		panel.repaint();
	}

}
