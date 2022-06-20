package main;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import main.*;

import MovingObject.*;

public abstract class Scene{
	public ArrayList<MovingObject> objects;
	public Window root;
	public Scene(Window root){
		this.root = root;
		objects = new ArrayList<MovingObject>();
	}
    public void keyPressed(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void update() {
		for(MovingObject object:objects) {
			object.update();
		}
	}
	public void updateCollision() {
		for(int i=0;i<objects.size();i++) {
			for(int j=0;j<i;j++) {
				try {
					objects.get(i).updateCollision(objects.get(j));
				}catch(Exception e){
					objects.get(j).updateCollision(objects.get(i));
				}
			}
		}
		for(MovingObject object:objects) {
			object.updateCollision();
		}
	}
	public void draw(Graphics g) {
		for(MovingObject object:this.objects) {
			object.draw(g);
		}
	}
}
