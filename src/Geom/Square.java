package Geom;
/**
 * This class represents a Square-4 points of 3D point in space.
 * @author Bar Genish
 * @author Elyashiv Deri
 */
public class Square implements Geom_element {
	private Point3D a;
	private Point3D b;
	private Point3D c;
	private Point3D d;

	public Square(Point3D a,Point3D b,Point3D c,Point3D d) {//constractor
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
	}
	public Square(double xa,double ya,double za,double xb,double yb,double zb,double xc,double yc,double zc,double xd,double yd,double zd) {//constractor
		this.a=new Point3D(xa,ya,za);
		this.b=new Point3D(xb,yb,zb);
		this.c=new Point3D(xc,yc,zc);
		this.d=new Point3D(xd,yd,zd);
	}
	/** 
	 * return the distance3d between the point3d p to our Square.
	 * */
	@Override
	public double distance3D(Point3D p) {
		return min(p.distance3D(a), p.distance3D(b),p.distance3D(c),p.distance3D(d));
	}
	/** 
	 * return the distance2d between the point3d p to our Square.
	 * */
	@Override
	public double distance2D(Point3D p) {
		return min(p.distance2D(a), p.distance2D(b),p.distance2D(c),p.distance2D(d));
	}
	/**
	 * help functions that return the min value of 4 doubles.
	 * @return double of the min number.
	 */
	private double min(double a,double b,double c,double d) {
		double min=Math.min(a, b);
		double min2=Math.min(c, d);
		return Math.min(min, min2);
	}
}
