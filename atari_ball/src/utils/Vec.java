package utils;

public class Vec {
	public double x=0,y=0;
	public Vec() {}
	public Vec(double x, double y) {
		this.x=x;
		this.y=y;
	}
	public Vec add(Vec b){
		return new Vec(this.x+b.x,this.y+b.y);
	}
	public Vec mul(double b) {
		return new Vec(this.x*b,this.y*b);
	}
	
}
