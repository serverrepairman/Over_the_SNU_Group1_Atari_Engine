package MovingObject;
import utils.*;

import java.awt.Color;
import java.awt.Graphics;

import main.Scene;

import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingObject {
	public Vec coordinate, velocity, a = new Vec(0,0);
	public Scene master;
	public MovingObject(Scene master, Vec coordinate) {
		this.coordinate = coordinate;
		this.velocity = new Vec(0,0);
		this.master = master;
	}
	public MovingObject(Scene master, Vec coordinate, Vec velocity) {
		this.coordinate = coordinate;
		this.velocity = velocity;
	}
	public void update() {
		coordinate = coordinate.add(velocity);
	}
	public abstract boolean updateCollision();
	public abstract boolean updateCollision(MovingObject object);
	public abstract void draw(Graphics g);
}