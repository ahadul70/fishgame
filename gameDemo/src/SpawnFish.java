//package gameDemo;

import java.util.Random;

public class SpawnFish {

	
	private ScoreBoard board;
	private Handler handler;
	private float x , y;
	private Random r = new Random();
	
	private int num1=0;
	private int lv=0;
	
	MainGame game;
	
	public SpawnFish(int x , int y , ScoreBoard board, Handler handler , MainGame game)
	{
		this.x = x;
		this.y = y;
		this.handler = handler;
		this.board = board;
		this.game = game;
		
	}

	public void twicking() {
		
		if((int)board.time == 0) {
			System.exit(1);
		}
	}
}

