package main; 
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Vector;

import MovingObject.*;
import utils.*;

public class GameView extends Frame{
    Image buffImg;
    Graphics buffG;
    Random random=new Random();
    public static int SIZEX=800;
    public static int SIZEY=480;
    public static double VEL=0.1;
    public Block stick=new Block(new Vec(360, 235),this.random_Color(),new Vec(80, 10));
    public Ball ball=new Ball(new Vec(50, 50), new Vec(0.01,0.02), this.random_Color(), 5);
    public static Vector<Block> blocks = new Vector<Block>();
    
    public GameView(){
        setTitle("Breakout-Style");
        setSize(SIZEX,SIZEY);
        setResizable(false); 
        setVisible(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyChar()) {
                    case 'a':
                    	stick.velocity.x = -VEL;
                        break;
                    case 'd':
                    	stick.velocity.x = VEL;
                        break;
                    case 'w':
                    	stick.velocity.y = -VEL;
                        break;
                    case 's':
                    	stick.velocity.y = VEL;
                        break;
                }
            }
            public void keyReleased(KeyEvent e) {
                stick.velocity = new Vec(0, 0);
            }
        });
        
        blocks.add(stick);
    }

    public void paint(Graphics g) {
        buffImg = createImage(getWidth(),getHeight()); 
        buffG = buffImg.getGraphics();
        update(g);
    }

    public void update(Graphics g) {
        buffG.clearRect(0, 0, 854, 480);
        stick.update();
        stick.draw(buffG);
        ball.update();
        ball.draw(buffG);
        g.drawImage(buffImg,0,0,this);
        repaint();
    }
    
    public Color random_Color() {
    	return new Color(random.nextFloat(),random.nextFloat(),random.nextFloat());
    }
}
