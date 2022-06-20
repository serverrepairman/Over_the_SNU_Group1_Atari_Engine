package BreakOut;
import java.awt.event.KeyEvent;
import java.util.Vector;

import MovingObject.Ball;
import MovingObject.Block;
import main.*;
import utils.Vec;

public class Main extends Scene{
    public static double VEL=0.1;
    public static int BLOCK_X=360, BLOCK_Y=235, BLOCK_WIDHT=80, BLOCK_HEIGHT=10;
    public static int BALL_X=50, BALL_Y=50, BALL_RADIUS=5;
    public static double BALL_VX=0.01, BALL_VY=0.02;
    public Window root;
    public Block stick;
    public Ball ball;
    public static Vector<Block> blocks = new Vector<Block>();
    public Main(Window root) {
    	super(root);
    	this.root=root;
    	stick=new Block(this, root.scr2pos(new Vec(BLOCK_X, BLOCK_Y)),root.random_Color(), new Vec(BLOCK_WIDHT, BLOCK_HEIGHT));
    	ball=new Ball(this, new Vec(BALL_X, BALL_Y), root.scr2pos(new Vec(BALL_VX,BALL_VY)), root.random_Color(), BALL_RADIUS);
    	objects.add(stick);
    	objects.add(ball);
    }
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
}
