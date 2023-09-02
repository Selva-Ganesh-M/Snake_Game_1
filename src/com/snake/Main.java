package com.snake;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("Snake Game");
		
		SnakeGame snakeGame = new SnakeGame();
		mainFrame.add(snakeGame);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);  
	}

}
