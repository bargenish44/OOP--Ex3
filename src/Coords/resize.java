package Coords;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.event.*;
import javax.swing.*;
import Geom.Point3D;
import Map.*;

public class resize{
	private ArrayList<Packman>Packmanarr=new ArrayList<>();
	private ArrayList<Fruit>Fruitarr=new ArrayList<>();
	private ImageIcon packmanimage;
	private ImageIcon cherryimage;
	private int counter=0;
	private int count=0;
	private Image img;
	public static void main(String[] args) {
		new resize();
	}
	public resize(){
		try {
			img = ImageIO.read(new File("Ariel1.png"));
			packmanimage=new ImageIcon("pacman.jpg");
			cherryimage=new ImageIcon("cherry.png");
			JFrame frame = new JFrame("OOP-EX3");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new BorderLayout());
			frame.add(new ImagePanel(img));
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);

		} catch (IOException | HeadlessException exp) {
			exp.printStackTrace();
		}
	}

	class ImagePanel extends JPanel implements MouseListener {

		private static final long serialVersionUID = 1L;
		double lat=0;
		double lon=0;
		private Image img;
		private Image scaled;
		double x=-1;
		double y=-1;
		public ImagePanel(String img) {
			this(new ImageIcon(img).getImage());
			this.addMouseListener(this); 
		}

		public ImagePanel(Image img) {
			this.img = img;
			this.addMouseListener(this); 
		}

		@Override
		public void invalidate() {
			super.invalidate();
			int width = getWidth();
			int height = getHeight();

			if (width > 0 && height > 0) {
				scaled = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			}
		}

		@Override
		public Dimension getPreferredSize() {
			return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(this), img.getHeight(this));
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(scaled, 0, 0, this.getWidth(),this.getHeight(),this);
			for(int i=0;i<Packmanarr.size();i++) {
				g.drawImage(packmanimage.getImage(), Packmanarr.get(i).getOrinet().ix(), Packmanarr.get(i).getOrinet().iy(),50,50,null);
				System.out.println(Packmanarr.get(i).getOrinet().ix()+" the x of the drawn image");
			}
			for(int i=0;i<Fruitarr.size();i++) {
				g.drawImage(cherryimage.getImage(), Fruitarr.get(i).getOrient().ix(), Fruitarr.get(i).getOrient().iy(),50,50,null);
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				x = e.getX();
				y = e.getY();
				System.out.println("left click you create new packman X: " + x + " Y: " + y);
				String test1= JOptionPane.showInputDialog("Please input packman speed : ");
				double speed=-1,radius=-1,high=0;
				boolean ans=true;
				boolean ans2=true;
				try {
					speed=Double.parseDouble(test1);
				}catch (NullPointerException n) {ans=false;}
				//catch(NumberFormatException ex) {speed=-1;}
				catch(Exception a) {speed=-1;}
				while(speed<=0&&ans) {
					test1= JOptionPane.showInputDialog("Please input packman speed(larger than 0) : ");	
					try {
						speed=Double.parseDouble(test1);
					}catch (NullPointerException n) {ans=false;}
					//catch(NumberFormatException ex) {speed=-1;}
					catch(Exception a) {speed=-1;}
				}
				if(ans) {
					String test2= JOptionPane.showInputDialog("Please input packman radius : ");
					try {
						radius=Double.parseDouble(test2);
					}catch (NullPointerException n) {ans=false;}
					//catch(NumberFormatException ex) {radius=-1;}
					catch(Exception a) {radius=-1;}
					while(radius<=0&&ans) {
						test2= JOptionPane.showInputDialog("Please input packman radius(larger than 0) : ");
						try {
							radius=Double.parseDouble(test2);
						}catch (NullPointerException n) {ans=false;}
						//catch(NumberFormatException ex) {radius=-1;}
						catch(Exception a) {radius=-1;}
					}
				}
				if(ans) {
					String test3=JOptionPane.showInputDialog("Please input packman high above ground : ");
					try {
						high=Double.parseDouble(test3);
					}catch (NullPointerException n) {ans=false;}
					//catch(NumberFormatException ex) {ans2=false;}
					catch(Exception a) {ans2=false;}
					while(!ans2&&ans) {
						test3= JOptionPane.showInputDialog("Please input packman high above ground(0 or lrager) : ");
						try {
							high=Double.parseDouble(test3);
						}catch (NullPointerException n) {ans=false;}
						//catch(NumberFormatException ex) {ans2=false;}
						catch(Exception a) {ans2=false;}
					}
				}
				if(ans) {
					Point3D p3d=new Point3D(x,y,high);
					Map_To m=new Map_To();
					m.setOrient(p3d);
					p3d=m.Pixel_TO_GPS(m.getOrient().x(), m.getOrient().y(),high);
					System.out.println(p3d.toString());
					Packmanarr.add(new Packman(count,p3d,speed,radius));
					System.out.println(m.getOrient().x()+" the place that it add");
					count++;
					repaint();
				}
				else 
					System.out.println("you quit before crete new packman");
			}
			else if(e.getButton() == MouseEvent.BUTTON3) {
				x = e.getX();
				y = e.getY();
				System.out.println("right click you create new fruit X: " + x + " Y: " + y);
				String test1= JOptionPane.showInputDialog("Please input fruit weight : ");
				double weight=-1,high=0;
				boolean ans=true;
				boolean ans2=true;
				try {
					weight=Double.parseDouble(test1);
				}//catch(NumberFormatException n) {weight=-1;}
				catch(NullPointerException n) {ans=false;}
				catch(Exception a) {weight=-1;}
				while(weight<=0&&ans) {
					test1= JOptionPane.showInputDialog("Please input fruit weight(larger than 0) : ");
					try {
						weight=Double.parseDouble(test1);
					}catch (NullPointerException n) {ans=false;}
					//catch(NumberFormatException ex) {weight=-1;}
					catch(Exception a) {weight=-1;}
				}
				if(ans) {
					String test2=JOptionPane.showInputDialog("Please input fruit high  : ");
					try {
						high=Double.parseDouble(test2);
					}catch (NullPointerException n) {ans=false;}
					//catch(NumberFormatException ex) {ans2=false;}
					catch(Exception a) {ans2=false;}
					while(!ans2&&ans) {
						test2= JOptionPane.showInputDialog("Please input valid packman high  : ");
						try {
							high=Double.parseDouble(test2);
						}catch (NullPointerException n) {ans=false;}
						//catch(NumberFormatException ex) {ans2=false;}
						catch(Exception a) {ans2=false;}
					}
				}
				if(ans) {
					Point3D p3d=new Point3D(x,y,high);
					Map_To m=new Map_To();
					m.setOrient(p3d);
					p3d=m.Pixel_TO_GPS(m.getOrient().x(), m.getOrient().y(),high);
					Fruitarr.add(new Fruit(counter,p3d,weight));
					counter++;
					repaint();			
				}
				else
					System.out.println("you quit before crete new fruit");
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}
}