package BreakOut;

import MovingObject.*;
import util.Vec;
import main.Window;

public class BreakOut extends Window{
	public BreakOut() {
		super("Break-Out",new Vec(800,480));
		setScene(addScene(new Main(this)));
	}
	public static main(String[] args) {
		BreakOut window = new BreakOut();
	}
}
