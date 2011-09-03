package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MenuPanel extends JPanel
{
	
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 600;
	
	public MenuPanel()
	{
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setBackground(Color.BLUE);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
	}
}