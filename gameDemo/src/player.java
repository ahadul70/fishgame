//package gameDemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.swing.ImageIcon;

public class player extends AllObject implements ImageObserver{

	
	Random r =new Random();
	Handler handler;
	public ScoreBoard board;
	private ID id;
	private Image image;
	private int w,h;
	public player(float x, float y, ID id, Handler handler) {
		
		super(x, y, id);
		this.handler = handler;

	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,40,20);
	}

	
	public void collision()
	{
		for(int i=0; i<handler.object.size();i++)
		{
			AllObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Fish ){
				if(getBounds().intersects(tempObject.getBounds()))
				{
					
					System.out.println("Collison");
					board.score += 5f;
					if(board.time < 90)
					board.time += 3f;
					bonus=5;
					remObj = true;
				}
			}
		}
	}



	public void twicking() {
			
			
			x += SpeedX;
			y += SpeedY;
		
			
			y = MainGame.range((int)y , (int)10 , MainGame.HEIGHT-70);
			x = MainGame.range((int)x , (int)10 , MainGame.WIDTH-40);
	
			ImageIcon ii = new ImageIcon("C:\\Users\\tlaw2\\Downloads\\Compressed\\New folder\\New folder\\shark4.png");
	        image = ii.getImage(); 
       
				collision();	
	}

	public void GUI(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
		
			g.setColor(Color.red);
			g2d.draw(getBounds());
			
			g.setColor(Color.black);
			g2d.drawImage(image, (int)(x-35), (int)(y-37), this);

	}

	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		return false;
	}
	

}
