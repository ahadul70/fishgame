//package gameDemo;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<AllObject> object = new LinkedList<AllObject>();

	public void twicking()
	{
		for(int i=0; i<object.size();i++)
		{
			AllObject temp = object.get(i);
			temp.twicking();
		}
	}

	
	public void GUI(Graphics g)
	{
		for(int i=0; i<object.size();i++)
		{
			AllObject temp = object.get(i);
			temp.GUI(g);
		}
	}
	

	
	public void addObject(AllObject object)
	{
		this.object.add(object);
	}
	public void removeObject(AllObject object)
	{
		this.object.remove(object);
	}
}
