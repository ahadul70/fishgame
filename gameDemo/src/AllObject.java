//package gameDemo;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class AllObject {

	
	protected float x , y;
	protected float SpeedX , SpeedY;
	protected ID Id;
	static boolean remObj;
	static int bonus=0;
	protected int key;
	
	public AllObject(float x, float y, ID Id)
	{
		this.x = x;
		this.y = y;
		this.Id = Id;
	}
	public abstract void twicking();
	public abstract void GUI(Graphics g);
	public abstract Rectangle getBounds();

	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y ){
		this.y = y;
	}
	
	public void setSpeedX(float SpeedX){
		this.SpeedX = SpeedX;
	}
	
	public void setSpeedY(float SpeedY){
		this.SpeedY = SpeedY;
	}
	
	public void setId(ID Id){
		this.Id = Id;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getSpeedX() {
		return SpeedX;
	}

	
	public float getSpeedY(){
		return SpeedY;
	}
	
	public ID getId(){
		return Id;
	}
	public void setKey(int key)
	{
		this.key=key;
	}
	public int getkey()
	{
		return key;
	}
	
	
	
	
	
	
	
	
}
