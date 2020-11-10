// filler code for pong provided by Mr. David

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong1 extends JPanel implements KeyListener {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1000, HEIGHT = 800, WINDOW_HEIGHT = 650;
	private final int PADDLE_WIDTH = 20, DIAM = 15, PADDLE_HEIGHT = 75;
	private final int PADDLE_SPEED = 4;
	private final double LENGTH = 10, G = 10;
	int x = WIDTH/2;
	int y = HEIGHT/2;
	int xx = WIDTH/2;
	int yy = HEIGHT/2;
	int SpeedX = 10,  SpeedY = 10;
	int u = HEIGHT / 2;
	int i = HEIGHT / 2;
	int SpeedX1 = - SpeedX,  SpeedY1 = - SpeedY;
	int x1 = WIDTH/2, y1 = HEIGHT/2;
	
	// your instance variables here, I've given you a few 
	private boolean up1, down1, up2, down2; 		// booleans to keep track of paddle movement
	private boolean solo = false;
	
	
	// this method moves the ball at each timestep
	public void move_ball() {

		x += SpeedX;
		y += SpeedY;
	}
	
	public void move_ball2() {

		x1 += SpeedX1;
		y1 += SpeedY1;
	}

		
	
			
	// this method moves the paddles at each timestep
	public void move_paddles() {
		if (i > 0) {
			i -= 10;
	}
		if else (i < 0) {
			i -= 10;
		}
	}
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
			
			if (x > WIDTH);{
				x ++;
			}
			
			if (x < 0);{
				y ++; 
			}

			if (y == 0 || y == HEIGHT);{
				SpeedY = - SpeedY;
			}
			if (x == WIDTH || x == 0);{
				SpeedX = - SpeedX;
			}
			if (y1 == 0 || y1 == HEIGHT);{
				SpeedY1 = - SpeedY1;
			}
			if (x1 == WIDTH || x1 == 0);{
				SpeedX1 = - SpeedX1;
			}
			
	}
	

	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draw your rectangles and circles here
		
		
		g.setColor(new Color(178,255,255));
		g.fillRect(50, HEIGHT/2,PADDLE_WIDTH, PADDLE_HEIGHT);
		
		
		g.setColor(new Color(178,255,255));
		g.fillRect(WIDTH - 50, u, PADDLE_WIDTH, PADDLE_HEIGHT);
		
		// ball 1 below//
		g.setColor(new Color(199,147,255));
		g.fillOval(x, y, DIAM * 2, DIAM * 2);
		
		// mirror ball below//
		g.setColor(new Color(199,147,255));
		g.fillOval(x1, y1, DIAM * 2, DIAM * 2);
		
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Kai", Font.BOLD, 20);
		g.setFont(f);
		g.setColor(new Color(199,147,255));
		g.drawString("P1 Score: ", WIDTH/5, 20);
		g.drawString("P2 Score: ", WIDTH*3/5, 20);
	}

	// defines what we want to happen if a keyboard button has 
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN) 
			i -= 10;
			
		if (keyCode == KeyEvent.VK_UP) 
			i += 10;

		if (e.getKeyChar() == 'w')
			u -= 10;
			
		
		if (e.getKeyChar() =='s')
			u += 10;
			
			
		// turn 1-player mode on
		if (e.getKeyChar() == '1') {
			
		}
			// fill this in
			
		// turn 2-player mode on
		if (e.getKeyChar() == '2') {
			
		}
			// fill this in
	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion based on which button is released
		if (keyCode == KeyEvent.VK_UP) 
		i ++;

		if (keyCode == KeyEvent.VK_DOWN) 
		u ++;
  
		if(e.getKeyChar() == 'w')
			// fill this in
		
		if (e.getKeyChar() == 's')
			// fill this in
	}
	
	// restarts the game, including scores
	public void restart() {

		// your code here
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, and check for collisions
			// every hundredth of a second
			move_ball();
			move_ball2();
			move_paddles();
			check_collisions();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong1();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong1() {
		JFrame frame = new JFrame();
		JButton button = new JButton("reset");
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				Pong1.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}