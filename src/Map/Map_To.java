package Map;

import Geom.*;

public class Map_To {

//���� ����� �� ������ ������� �'� �� ��
	Point3D left_Up = new Point3D(32.105770,  35.202469);

	Point3D Right_Up = new Point3D(32.105770 , 35.211588);

	Point3D left_Down = new Point3D(32.101899, 35.202469);

	Point3D Right_Down = new Point3D(32.101899, 35.211588);
	
	//����� �� �����

	double x_length = this.Right_Up.y()-this.left_Up.y();

	double y_length = this.left_Down.x()-this.left_Up.x();



//GPS ���� ������ ������� 
	public  Point3D Pixel_TO_GPS(double Dx , double Dy) {

		double lon_x = Dx * x_length+left_Up.y();

		double lat_y = Dy * y_length+Right_Up.x();

		Point3D answrInGps = new Point3D(lat_y,lon_x);

		return answrInGps;
	}
	
//���� �����
	public Point3D GPS_TO_Pixel(Point3D p) {

		double Dx = (p.y()-left_Up.y())/x_length;

		double Dy = (p.x()-left_Up.x())/y_length;

		return new Point3D(Dx,Dy);

	}


//����� �����
	public double Distance_IN_Pixels(Point3D p1, Point3D p2) {

		Point3D ans_X =  Pixel_TO_GPS(p1.x(),p1.y());

		Point3D ans_Y =  Pixel_TO_GPS(p2.x(),p2.y());

		double answer = ans_X.distance3D(ans_Y);

		return answer;

	}


}
