package geom.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

public class Ellipse extends Component {

	private static final float	dash1[]	= { 10.0f };

	private int					xPos	= 0;
	private int					yPos	= 0;

	public Ellipse(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		setSize(100, 100);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D ellipse = new Ellipse2D.Float(xPos, yPos, 100, 100);
		Paint paint = Color.RED;
		Stroke stroke = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
		g2.setStroke(stroke);
		g2.setPaint(paint);
		g2.fill(ellipse);
		g2.draw(ellipse);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		final Ellipse ellipse = new Ellipse(100, 100);
		ellipse.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Hello!");
			}
		});
		frame.getContentPane().add(ellipse);
		frame.setVisible(true);
	}

}
