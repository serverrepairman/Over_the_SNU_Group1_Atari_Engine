package MovingObject;
import utils.*;

import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingObject {
	public Vec coordinate, velocity, a = new Vec(0,0);
	public Color color;
	public MovingObject(Vec coordinate, Color color) {
		this.coordinate = coordinate;
		this.velocity = new Vec(0,0);
		this.color = color;
	}
	public MovingObject(Vec coordinate, Vec velocity, Color color) {
		this.coordinate = coordinate;
		this.velocity = velocity;
		this.color = color;
	}
	public void update() {
		coordinate = coordinate.add(velocity);
	}
	public abstract boolean updateCollision();
	public abstract void draw(Graphics g);
}
