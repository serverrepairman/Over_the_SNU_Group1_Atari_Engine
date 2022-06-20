package main;
import java.util.ArrayList;
import java.awt.Graphics;
import MovingObject.*;

public abstract class Scene{
	ArrayList<MovingObject> objects;
	public Scene(){
		objects = new ArrayList<MovingObject>();
	}
	public abstract void mousePressEvent();
	public abstract void mouseMoveEvent();
	public abstract void mouseReleaseEvent();
	public void update() {
		for(MovingObject object:this.objects) {
			object.update();
		}
	}
	public void draw(Graphics g) {
		for(MovingObject object:this.objects) {
			object.draw(g);
		}
	}
	public abstract void main(Graphics g);
}
