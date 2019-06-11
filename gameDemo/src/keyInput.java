//package gameDemo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyInput extends KeyAdapter{

	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	
	public keyInput(Handler handler)
	{
		this.handler = handler;
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;

	}


	public void keyPressed(KeyEvent e) {
		int key=  e.getKeyCode();
		for(int i =0; i<handler.object.size(); i++)
		{
			AllObject tempObject = handler.object.get(i);
				
			if(tempObject.getId() == ID.player)
			{
				if(key == KeyEvent.VK_W) { tempObject.setSpeedY(-3); 	keyDown[0] = true; }
				if(key == KeyEvent.VK_S) { tempObject.setSpeedY(3);	keyDown[1] = true;}
				if(key == KeyEvent.VK_D) { tempObject.setSpeedX(3);	keyDown[2] = true; }
				if(key == KeyEvent.VK_A) { tempObject.setSpeedX(-3);	keyDown[3] = true;}
			}
			

		}
		if(key == KeyEvent.VK_ESCAPE)System.exit(1);
		
	}
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i =0; i<handler.object.size(); i++)
		{
			AllObject tempObject = handler.object.get(i);
			
			
			if(tempObject.getId() == ID.player)
			{
				if(key == KeyEvent.VK_W) keyDown[0] = false;
				if(key == KeyEvent.VK_S) keyDown[1] = false;
				if(key == KeyEvent.VK_D) keyDown[2] = false;
				if(key == KeyEvent.VK_A) keyDown[3] = false;
				
				if(!keyDown[0] && !keyDown[1]) tempObject.setSpeedY(0);
				if(!keyDown[2] && !keyDown[3]) tempObject.setSpeedX(0);
			}
			
		}
		
	}
	
	
	
	
	
}
