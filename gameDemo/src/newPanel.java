//package gameDemo;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class newPanel extends Canvas{

	public newPanel(int width, int height, String title, MainGame game){
		
		JFrame frame = new JFrame(title);
	
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
	
	}
}
