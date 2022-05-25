package MovingObject;

import java.awt.Color;
import java.awt.Graphics;

import main.GameView;
import utils.Vec;

public class Block extends MovingObject{
	Vec length;
	public Block(Vec coordinate, Color color, Vec length) {
		super(coordinate, color);
		this.length=length;
	}
	public Block(Vec coordinate, Vec velociy, Color color, Vec length) {
		super(coordinate, velociy, color);
		this.length=length;
	}
	public boolean updateCollision() {
		boolean checker = true;
		if (GameView.SIZEX<coordinate.x+length.x)
			coordinate.x = GameView.SIZEX-length.x; checker=false;
		if(coordinate.x<0)
			coordinate.x=0;checker=false;
		if (GameView.SIZEY<coordinate.y+length.y)
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
