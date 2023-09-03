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
	final int[] y = new int[SCREEN_HEIGHT_Y*SCREEN_WIDTH_X];
	
	int bodyPart = 2;
	int score = 0;
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
		createFood();
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
		
//		draw grid lines
		for (int i=0; i<SnakeGame.SCREEN_WIDTH_X; i++) {
			g.drawLine(i*SnakeGame.SIZE, 0, i*SnakeGame.SIZE, SnakeGame.SCREEN_HEIGHT_Y);			
		}
		for (int i=0; i<SnakeGame.SCREEN_HEIGHT_Y; i++) {
			g.drawLine(0, i*SnakeGame.SIZE, SnakeGame.SCREEN_WIDTH_X, i*SnakeGame.SIZE);			
		}
		
//		draw food
		g.setColor(Color.yellow);
		g.fillOval(foodX, foodY, SIZE, SIZE);
		
//		draw snake
		for (int i=0; i<bodyPart; i++) {
			g.setColor(Color.red);
			g.fillRect(x[i], y[i], SIZE, SIZE);
		}
	}
	
	public void move() {
		for(int i=bodyPart; i>0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		x[0] = x[0]+currentDirectionX*SIZE;
		y[0] = y[0]+currentDirectionY*SIZE;
	}
	
	public void createFood() {
		random = new Random();
		foodX = random.nextInt(((int)SCREEN_WIDTH_X/SIZE))*SIZE;
		foodY = random.nextInt(((int)SCREEN_HEIGHT_Y/SIZE))*SIZE;		
	}
	
	public void checkFood() {
		if (x[0]==foodX && y[0]==foodY){
			this.score++;
			this.bodyPart++;
			this.createFood();
		}
	}
	
	
	public void checkCollision() {
//		check if the snake bit itself
		for (int i = this.bodyPart; i>0; i--) {
			if (x[0]==x[i] && y[0] == y[i]) {
				this.running = false;
			}
		}
		
//		checking if snake hit the wall
		if (x[0]<0) {
			this.running = false;
		}else if (x[0]>SnakeGame.SCREEN_WIDTH_X){
			this.running = false;
		}else if (y[0]<0) {
			this.running = false;
		}else if (y[0]>SnakeGame.SCREEN_HEIGHT_Y) {
			this.running = false;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		 
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_LEFT:
			if (this.currentDirectionX!=1) {
				this.currentDirectionX = -1;
				this.currentDirectionY = 0;				
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (this.currentDirectionX!=-1) {
				this.currentDirectionX = 1;
				this.currentDirectionY = 0;				
			}
			break;
		case KeyEvent.VK_UP:
			if (this.currentDirectionY!=1) {
				this.currentDirectionX = 0;
				this.currentDirectionY = -1;				
			}
			break;
		case KeyEvent.VK_DOWN:
			if (this.currentDirectionY!=-1) {
				this.currentDirectionX = 0;
				this.currentDirectionY = 1;				
			}
			break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (running) {
			move();
			checkFood();
			checkCollision();
		}
		repaint();
	}
}
