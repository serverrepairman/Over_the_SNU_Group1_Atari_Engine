package MovingObject;

import java.awt.Color;
import java.awt.Graphics;

import main.Window;
import main.Scene;
import utils.Vec;

public class Block extends MovingObject{
	Vec size;
	Color color;
	public Block(Scene master, Vec coordinate,Color color, Vec size) {
		super(master,coordinate);
		this.color=color;
		this.size=size;
	}
	public Block(Scene master, Vec coordinate, Vec velociy, Color color, Vec size) {
		super(master, coordinate, velociy);
		this.color=color;
		this.size=size;
	}
	public boolean updateCollision() {
		boolean checker = true;
		if (-master.root.getWidth()/2>coordinate.x-size.x/2)
			coordinate.x = -master.root.getWidth()/2+size.x/2; checker=false;
		if (master.root.getWidth()/2<coordinate.x+size.x/2)
			coordinate.x = master.root.getWidth()/2-size.x/2; checker=false;
		if (-master.root.getHeight()/2>coordinate.y-size.y/2)
			coordinate.y = -master.root.getHeight()/2+size.y/2; checker=false;
		if (master.root.getHeight()/2<coordinate.y+size.y/2)
			coordinate.y = master.root.getHeight()/2-size.y/2; checker=false;
		return checker;
	}
	public boolean updateCollision(MovingObject object) {
		if(object.getClass().getName()=="MovingObject.Ball") {
			object.updateCollision(this);
		}
		return true;
	}
	public void update() {
		super.update();
		updateCollision();
	}
	public void draw(Graphics g) {
		g.setColor(color);
		Vec scr=master.root.pos2scr(coordinate).sub(size.div(2));
		g.fillRect((int)(scr.x),(int)(scr.y), (int)(size.x), (int)(size.y));
	}
}
