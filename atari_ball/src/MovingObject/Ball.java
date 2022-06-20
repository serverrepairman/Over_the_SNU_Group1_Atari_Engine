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
		boolean checker = true;
		if (master.root.getWidth()-radius<coordinate.x || radius>coordinate.x)
			velocity.x*=-1; checker = false;
		if (master.root.getHeight()-radius<coordinate.y || radius>coordinate.y)
			velocity.y*=-1; checker = false;
		return checker;
	}
	public boolean updateCollision(MovingObject object) {
		if(object.getClass()==Block) {
			this.updateCollision(object)
		}
		return true;
	}
	public boolean updateCollision(Block block) {
		boolean checker = true;
		if (master.root.getWidth()-radius<block.length.x+block.coordinate.x || radius>block.coordinate.x)
			velocity.x*=-1; checker = false;
		if (master.root.getHeight()-radius<block.length.y+block.coordinate.y || radius>block.coordinate.y)
			velocity.y*=-1; checker = false;
		return checker;
	}
	public void update() {
		super.update();
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)(coordinate.x),(int)(coordinate.y), 2*(int)radius, 2*(int)radius);
	}
}
