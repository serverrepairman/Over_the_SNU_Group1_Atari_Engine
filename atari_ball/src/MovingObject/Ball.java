package MovingObject;

import java.awt.*;
import java.awt.Graphics.*;

import main.GameView;
import main.Scene;
import utils.Vec;

public class Ball extends MovingObject {
	private double radius;
	public Color color;
	public Ball(Scene master, Vec coordinate, Color color, double radius) {
		super(master, coordinate);
		this.color = color;
		this.radius=radius;
	}
	public Ball(Scene master, Vec coordinate, Vec velocity, Color color, double radius) {
		super(master, coordinate, velocity);
		System.out.println(velocity);
		this.color = color;
		this.radius = radius;
	}
	public boolean updateCollision() {
		System.out.println(velocity.x);
		System.out.println(velocity.y);
		boolean checker = true;
		if (-master.root.getWidth()/2>coordinate.x-radius || master.root.getWidth()/2<coordinate.x+radius)
			velocity.x*=-1; checker = false;
		if (-master.root.getHeight()/2>coordinate.y-radius || master.root.getHeight()/2<coordinate.y+radius)
			velocity.y*=-1; checker = false;
		return checker;
	}
	public boolean updateCollision(MovingObject object) {
		if(object.getClass().getName()=="MovingObject.Block") {
			return this.updateCollision((Block)object);
		}
		return true;
	}
	public boolean updateCollision(Block block) {
		boolean checker = true;
		if (coordinate.x-radius<block.size.x+block.coordinate.x && coordinate.x+radius>block.coordinate.x && coordinate.y-radius<block.size.y+block.coordinate.y && coordinate.y+radius>block.coordinate.y)
			velocity.y*=-1; checker = false;
		return checker;
	}
	public void update() {
		super.update();
	}
	public void draw(Graphics g) {
		g.setColor(color);
		Vec scr=master.root.pos2scr(coordinate);
		g.fillOval((int)(scr.x),(int)(scr.y), 2*(int)radius, 2*(int)radius);
	}
}
