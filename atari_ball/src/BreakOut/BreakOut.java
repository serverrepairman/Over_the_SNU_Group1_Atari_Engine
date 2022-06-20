package BreakOut;

import MovingObject.*;
import utils.Vec;
import main.Window;

public class BreakOut extends Window{
	public BreakOut() {
		super("Break-Out",new Vec(800,480));
		setScene(addScene(new Main(this)));
	}
	public static void main(String[] args) {
		BreakOut window = new BreakOut();
	}
}
