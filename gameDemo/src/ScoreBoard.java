//package gameDemo;

import java.awt.Color;
import java.awt.Graphics;

public class ScoreBoard {

	private Fish fish ;
	
	
	public static float score = 0;
	public static float time = 120;
	private Handler handler;
	
	
	public ScoreBoard(Handler handler)
	{
		this.handler = handler;
	}
	
	
	
	
	public void twicking()
	{
		time -= 0.02f;		
		if(time <= 0)
			this.time = 0;
		
		

	}
	 
	public void GUI(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(519, 20, 92, 25);
		g.setColor(Color.yellow);
		g.fillRoundRect(520, 20, 90, 25, 50, 12 );

		g.setColor(Color.black);
		g.fillOval(522, 25, 15, 15);
		
		g.setColor(Color.yellow);
		g.fillOval(290, 10, 40, 40);
			
		g.setColor(Color.black);
		g.drawString(""+(int)score,538,36);
			
		g.drawString("Timer", 297, 10);
		g.drawString(""+(int)time,303,33);

	}

	
}
