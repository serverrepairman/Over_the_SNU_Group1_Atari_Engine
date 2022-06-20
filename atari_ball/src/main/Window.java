package main;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;

import MovingObject.Ball;
import MovingObject.Block;
import utils.Vec;

public abstract class Window extends JFrame{
	public ArrayList<Scene> scenes;
	int sceneNum;
	String title;
	Image buffImg;
    Graphics buffG;
    Random random = new Random();
    private Vec size;
    public double VEL=0.1;

    public Window(String title, Vec size){
    	
    	scenes = new ArrayList<Scene>();
    	
    	this.title = title;
        setTitle(title);
        
        this.size = size;
        setSize((int)size.x,(int)size.y);
        
        setResizable(false); 
        setVisible(true);
    }
    @Override
    public int getWidth() {return (int)size.x;}
    @Override
    public int getHeight() {return (int)size.y;}
    
    @Override
    public void paint(Graphics g) {
        buffImg = createImage(getWidth(),getHeight()); 
        buffG = buffImg.getGraphics();
        update(g);
    }
    
    @Override
    public void update(Graphics  g) {
        buffG.clearRect(0, 0, 854, 480);
        scenes.get(sceneNum).update();
        scenes.get(sceneNum).draw(buffG);
        g.drawImage(buffImg,0,0,this);
        repaint();
    }
    
    public int addScene(Scene inputScene) {
    	scenes.add(inputScene);
    	return scenes.size()-1;
    }
    
    public void setScene(int sceneIndex) {
    	sceneNum = sceneIndex;
        Container c = getContentPane();
        c.setLayout(null);
        
    	addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {scenes.get(sceneNum).keyPressed(e);}
            public void keyReleased(KeyEvent e) {scenes.get(sceneNum).keyReleased(e);}
            public void keyTyped(KeyEvent e) {scenes.get(sceneNum).keyTyped(e);}
        });
    	c.addMouseListener( new MouseListener() {
			public void mousePressed(MouseEvent e) {scenes.get(sceneNum).mousePressed(e);}
			public void mouseReleased(MouseEvent e) {scenes.get(sceneNum).mouseReleased(e);}
			public void mouseClicked(MouseEvent e) {scenes.get(sceneNum).mouseClicked(e);}
			public void mouseEntered(MouseEvent e) {scenes.get(sceneNum).mouseEntered(e);}
			public void mouseExited(MouseEvent e) {scenes.get(sceneNum).mouseExited(e);}
		});
    }
    
    public Vec pos2scr(Vec pos) {
    	Vec re = new Vec(pos.x,-pos.y);
    	return re.add(size.mul(0.5));
    }
    
    public Vec scr2pos(Vec scr) {
    	return new Vec(scr.x-size.x/2,size.y/2-scr.y);
    }
    
    public Color random_Color() {
    	return new Color(random.nextFloat(),random.nextFloat(),random.nextFloat());
    }
}
