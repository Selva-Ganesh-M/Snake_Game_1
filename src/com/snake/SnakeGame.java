package com.snake;

import java.awt.Color;
import java.awt.Dimension;
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
		setPreferredSize(new Dimension(SCREEN_HEIGHT_Y, SCREEN_WIDTH_X));
		setBackground(Color.black);
		setFocusable(true);
		this.addKeyListener(this);
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
