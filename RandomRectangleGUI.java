//MERCYLENE GWIZA

package randomrectanglegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RandomRectangleGUI {
	JFrame frame;
	RandomRectDrawPanel drawPanel = new RandomRectDrawPanel();
	JButton colorButton;
	JButton sizeButton;

	public static void main(String[] args) {
		RandomRectangleGUI gui = new RandomRectangleGUI();

		gui.go();
	}

	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		colorButton = new JButton("Click me for a random colour");
		sizeButton = new JButton("Click me for a random size");

		frame.getContentPane().add(BorderLayout.PAGE_START, colorButton);
		frame.getContentPane().add(BorderLayout.PAGE_END, sizeButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setSize(500, 500);
		frame.setVisible(true);

		
		colorButton.addActionListener(new RandomColorListener());
		sizeButton.addActionListener(new SizeListener());
	}

	class RandomRectDrawPanel extends JPanel {
		Color color;
		int height = 50;
		int width = 80;
		int x = 50;
		int y = 50;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}

	}
//RANDOMCOLORLISTENER CLASS
	class RandomColorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {

			int r = (int) (Math.random() * 255);
			int g = (int) (Math.random() * 255);
			int b = (int) (Math.random() * 255);
			drawPanel.setForeground(new Color(r, g, b));

		}

	}
//SIZELISTENER CLASS
	class SizeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {

			int displace = 5;
			int height = (int) (Math.random() * frame.getHeight());
			int width = (int) (Math.random() * frame.getWidth());
			int x = 50;
			int y = 50;

			int temp;
			if ((y + height) > frame.getHeight()) { // this to keep all of the height of the rectangle inside the draw panel
				temp = frame.getHeight() - (y + height);
				height = height + temp - displace; // temp is a negative number
			}
			if (height < 5)
				height = 5;// minimum height

			if ((x + width) > frame.getWidth()) { // this to keep all of the width of the rectangle inside the draw panel
				temp = frame.getWidth() - (x + width);
				width = width + temp - displace; // temp is a negative number
			}
			if (width < 5)
				width = 5; // minimum width

			drawPanel.setBounds(x, y, width, height);

		}
	}

}