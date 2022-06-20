package MovingObject;

import java.awt.Color;
import java.awt.Graphics;

import main.GameView;
import main.Scene;
import utils.Vec;

public class Block extends MovingObject{
	Vec length;
	Color color;
	public Block(Scene master, Vec coordinate,Color color, Vec length) {
		super(master,coordinate);
		this.color=color;
		this.length=length;
	}
	public Block(Scene master, Vec coordinate, Vec velociy, Color color, Vec length) {
		super(master, coordinate, velociy);
		this.color=color;
		this.length=length;
	}
	public boolean updateCollision() {
		boolean checker = true;
		if (master.root.getWidth()<coordinate.x+length.x)
			coordinate.x = GameView.SIZEX-length.x; checker=false;
		if(coordinate.x<0)
			coordinate.x=0;checker=false;
		if (master.root.getHeight()<coordinate.y+length.y)
			coordinate.y = GameView.SIZEY-length.y;checker=false;
		if(coordinate.y<0)
			coordinate.y=0;checker=false;
		return checker;
	}
	public void update() {
		super.update();
		updateCollision();
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int)(coordinate.x),(int)(coordinate.y), (int)(length.x), (int)(length.y));
	}
}
