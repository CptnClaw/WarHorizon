package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame 
{
	
	private MenuPanel panel;
	
	public GameFrame()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new MenuPanel();
		this.setContentPane(panel);
		this.pack();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		panel.repaint();
	}

}
