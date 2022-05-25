package MovingObject;

import java.awt.*;
import java.awt.Graphics.*;

import main.GameView;
import utils.Vec;

public class Ball extends MovingObject {
	private double radius;
	public Ball(Vec coordinate, Color color, double radius) {
		super(coordinate, color);
		this.radius=radius;
	}
	public Ball(Vec coordinate, Vec velocity, Color color, double radius) {
		super(coordinate, velocity, color);
		System.out.println(velocity);
		this.radius=radius;
	}
	public boolean updateCollision() {
		boolean checker = true;
		if (GameView.SIZEX-radius<coordinate.x || radius>coordinate.x)
			velocity.x*=-1; checker = false;
		if (GameView.SIZEY-radius<coordinate.y || radius>coordinate.y)
			velocity.y*=-1; checker = false;
		return checker;
	}
	public void update() {
		super.update();
		updateCollision();
		for(Block nowBlock:GameView.blocks) {
			updateCollision(nowBlock);
		}
	}
	public boolean updateCollision(Block block) {
		boolean checker = true;
		if (GameView.SIZEX-radius<block.length.x+block.coordinate.x || radius>block.coordinate.x)
			velocity.x*=-1; checker = false;
		if (GameView.SIZEY-radius<block.length.y+block.coordinate.y || radius>block.coordinate.y)
			velocity.y*=-1; checker = false;
		return checker;
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)(coordinate.x),(int)(coordinate.y), 2*(int)radius, 2*(int)radius);
	}
}
