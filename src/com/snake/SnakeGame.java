package com.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
	
	static final int SCREEN_WIDTH_X = 600; 
	static final int SCREEN_HEIGHT_Y = 600;
	static final int SIZE = 30;
	static final int DELAY = 100;
	
	final int[] x = new int[SCREEN_HEIGHT_Y*SCREEN_WIDTH_X];
	final int[] Y = new int[SCREEN_HEIGHT_Y*SCREEN_WIDTH_X];
	
	int bodyPart = 2;
	int foodEatten; 
	int foodX, foodY;
	int currentDirectionX = 1;
	int currentDirectionY = 0;
	boolean running = false;
	Random random;
	Timer timer;
	
	public SnakeGame(){
		this.setPreferredSize(new Dimension(SCREEN_HEIGHT_Y, SCREEN_WIDTH_X));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(this);
		this.startGame();
	}
	
	public void startGame() {
		this.running  = true;
		this.timer = new Timer(SnakeGame.DELAY, this);
		this.timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.draw(g);
	}
	
	public void draw(Graphics g) {
		for (int i=0; i<SnakeGame.SCREEN_WIDTH_X; i++) {
			g.drawLine(i*SnakeGame.SIZE, 0, i*SnakeGame.SIZE, SnakeGame.SCREEN_HEIGHT_Y);			
		}
		for (int i=0; i<SnakeGame.SCREEN_HEIGHT_Y; i++) {
			g.drawLine(0, i*SnakeGame.SIZE, SnakeGame.SCREEN_WIDTH_X, i*SnakeGame.SIZE);			
		}
		
		g.setColor(Color.yellow);
		g.fillOval(foodX, foodY, SIZE, SIZE);
	}
	
	public void move() {
		
	}
	
	public void createFood() {
		foodX = random.nextInt(((int)SCREEN_WIDTH_X/SIZE)*SIZE);
		foodY = random.nextInt(((int)SCREEN_HEIGHT_Y/SIZE)*SIZE);		
	}
	
	public void checkFood() {
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		 
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("The key pressed is: "+e.getKeyChar());
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
