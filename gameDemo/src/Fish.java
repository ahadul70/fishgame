//package gameDemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;


public class Fish extends AllObject implements ImageObserver{

	private Handler handler;
	private Image image;
	private ID Id;
	
    private int w  = 20;
    private int h = 20;
    
	public Fish(float x, float y, ID Id , Handler handler) {
		
		super(x, y, Id);
		
		this.handler = handler;
		
		SpeedX = 1.7f;
		SpeedY = 0.9f;
		
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
	}
	
	public void twicking() {
		if(remObj == true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			handler.removeObject(this);
		}
		remObj =false;
		x += SpeedX;
		y += SpeedY;
		
		
		if(y<=0 || y >= MainGame.HEIGHT-25) 
			SpeedY *= -1.0f;					
		
		if(x<=-00 || x >= MainGame.WIDTH+2) 
			SpeedX *= -1.0f;

		
		ImageIcon ii = new ImageIcon("C:\\Users\\tlaw2\\Downloads\\Compressed\\New folder\\New folder\\pray1.png");
        image = ii.getImage(); 

	}

	public void GUI(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(image, (int)(x-20), (int)(y-20), this);
		
		
	}

	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		return false;
	}

}
