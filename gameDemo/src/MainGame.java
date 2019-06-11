//package gameDemo;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.ImageIcon;

public class MainGame extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	
		static int WIDTH = 600;
		 static int HEIGHT = 848;
		 
		 private Thread thread;
		 private boolean running =false;
		 private ScoreBoard board;
		 private Handler handler;
		 
		 private SpawnFish newFish;
		 private Random r;
		 private Image image;
		 
		 public MainGame()
		 {	
			 this.requestFocusInWindow();

			 handler =new Handler();
			 board = new ScoreBoard(handler);

			 
			 this.addKeyListener(new keyInput(handler));
			 
			 r= new Random();
			 
			 new newPanel(WIDTH,HEIGHT,"Fishing Game",this);
			
//		 im = new image(handler);
			 
		 newFish =  new SpawnFish((WIDTH/2) -30, (HEIGHT/2) -30 , board, handler, this);
		
		 
			 handler.addObject(new player(300,300, ID.player , handler));
		 
		 

			// fish = new Fish();
		 while(true){
			 for(int i =0 ;i<2 ; i++) {
					
				 int w = 300;
			 int h= 300;
			 
					 handler.addObject(new Fish(r.nextInt(WIDTH-20),r.nextInt(HEIGHT-20) , ID.Fish , handler));
			 w=w+30;
			 h=h+30;
			 try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 }
		}	 
 
		 
		 }
		 
		 
		 public synchronized void start() {
			 Thread thread = new Thread(this);
			 thread.start();
			 running = true;
		 }
		 
		 
		 public synchronized void stop()
		 {
			 try {
				 thread.join();
				 running = false;
			 }
			 catch(Exception ex) {
				 ex.printStackTrace();
			 }
		 }
	
		  
	
	public void run()
	{
		 this.requestFocusInWindow();

		long pastTime = System.nanoTime();
		double defaultFrame = 60.0;
		double perFrame = 1000000000/defaultFrame;
		System.out.println(perFrame);
		double delay = 0;
		
		int frames = 0;
		
				long timer = System.currentTimeMillis();

		while(running)
		{
			long currentTime = System.nanoTime();
			delay += (currentTime - pastTime) / perFrame;
			pastTime = currentTime;
			
			while(delay >= 1)
			{
				twicking();
				
				delay--;
			}
			
			if(running)
			{
				GUI();
				frames++;
			}
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
	
		stop();
		
	}
	
	
	public void twicking()
	{
	
			handler.twicking();
			board.twicking();
			newFish.twicking();	

		
	}
	
	
	public void GUI()
	{
		 this.requestFocusInWindow();

		BufferStrategy buffer = this.getBufferStrategy();
		
		if(buffer == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = buffer.getDrawGraphics();

		ImageIcon ii = new ImageIcon("C:\\Users\\tlaw2\\Downloads\\Compressed\\New folder\\New folder\\back.png");
        image = ii.getImage(); 
       
        	Graphics2D g2d = (Graphics2D) g;
		
			g2d.drawImage(image, 0, 0, this);
		
		
			handler.GUI(g);
			board.GUI(g);

			g.dispose();
			buffer.show();
	}
	
	
	public static int range(int var , int min , int max)
	{
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else return var;
	}
	
	

	
	public static void main(String args[]) {	
	
		new MainGame();

	}

}
