package com.tirumala;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int screenWidth = 600, screenHeight = 600;
	private Thread thread;
	private boolean running = false;
	private Monkey monkey;
	private Banana banana;
	private int score = -1;
	private int x=0, y=0;
	private Key key;
	private Random random = new Random();
	private String timeupMsg = "Times up..!!";
	private String gameMsg = null;
	private String scoreString = "Score: ";
	private String scoreMsg = null;
	private static final Font gameFONT = new Font("Tahoma", Font.BOLD, 25);
	private static final Font scoreFONT = new Font("Tahoma", Font.BOLD, 16);
	private static final Font timeupFONT = new Font("Tahoma", Font.BOLD, 25);
	
	int scoreX = getWidth() / 10;
	int scoreY = getHeight() / 10;
	public static final int numOfGrids=20;
	public static final int tileSize =screenWidth/numOfGrids;
	public static int time=40;
	public static int bananaTime = 8;
	
	public Timer timer = new Timer(1000, new ActionListener() {
	@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			time--;
			if(time<=0 && running == true){
				stop();
				timer.stop();
			}else{
				
			}
		}
	});
	
	public Timer bananaTimer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			bananaTime--;
			if(bananaTime<=0){
				int bx= random.nextInt(19);
				int by= random.nextInt(19);
				banana = new Banana(bx, by, tileSize);
				bananaTime=8;
			}
			else{
				
			}
		}
	});
	
	
	
	
	public Screen(){
		monkey=new Monkey(x,y,tileSize);
		timer.start();
		bananaTimer.start();
		key = new Key();
		addKeyListener(key);
		setBackground(Color.GREEN);
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		banana = new Banana(x, y, tileSize);
		start();
		setFocusable(true);
	}
	
	public void start(){
		running = true;
		thread = new Thread(this, "Game Engine");
		thread.start();
	}
	
	public void stop(){
		running = false;
		addKeyListener(null);
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(running){
			
			tick();
			repaint();
		}
	}
	
	public void tick(){
		//System.out.println(monkey.mX +" "+ banana.getX() +" "+ monkey.mY +" "+ banana.getY());
		if( monkey.mX == banana.getbX()*tileSize && monkey.mY == banana.getbY()*tileSize){
				
				int bx= random.nextInt(19);
				int by= random.nextInt(19);
				banana = new Banana(bx, by, tileSize);
				score++;
				bananaTime=8;
			}
		scoreMsg= scoreString+String.valueOf(score)+" Total Game Time: "+time+" Banana Time: "+bananaTime;
	}
	
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.clearRect(0, 0, screenWidth, screenHeight);
		g.setColor(new Color(10079385));
		g.fillRoundRect(0, 0, screenWidth, screenHeight, 0, 0);
		
		//draw horizontal and vertical lines
		for(int i =0;i<numOfGrids;i++){
			g.setColor(Color.BLACK);
			g.drawLine(i*tileSize, 0, i*tileSize, screenHeight);
		}
		//draw horizontal and vertical lines 
		for(int i =0;i<numOfGrids;i++){
			g.setColor(Color.BLACK);
			g.drawLine(0, i*tileSize, screenWidth, i*tileSize);
		}
		
		
		monkey.draw(g); 
		int centerX = getWidth() / 2;
		int centerY = getHeight() / 2;
		if(score == 5){
			
			gameMsg = "Congrats you have won..!!";
			
			g.setFont(gameFONT);
			g.setColor(Color.BLUE);
			g.drawString(gameMsg, centerX - g.getFontMetrics().stringWidth(gameMsg) / 2, centerY + 50);
			running = false;
			stop();
		}
		else if(time<=0){
			g.setFont(timeupFONT);
			g.setColor(Color.RED);
			g.drawString(timeupMsg, centerX - g.getFontMetrics().stringWidth(timeupMsg) / 2, centerY + 50);
		}
		
		banana.draw(g);
		g.setFont(scoreFONT);
		g.setColor(Color.RED);
		g.drawString(scoreMsg, scoreX, scoreY+20);
		
	}
	
	public class Key implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			if(running){
			//System.out.println("keycode "+e.getKeyCode());
			int key = e.getKeyCode();
			switch(key){
			case KeyEvent.VK_RIGHT:
				if(monkey.mX<screenWidth-tileSize)
					monkey.moveRight();
				break;
			case KeyEvent.VK_LEFT:
				if(monkey.mX>0)
					monkey.moveLeft();
				break;
			case KeyEvent.VK_UP:
				if(monkey.mY>0)
				monkey.moveUp();
				break;
			case KeyEvent.VK_DOWN:
				if(monkey.mY<screenHeight-tileSize)
				monkey.moveDown();
				break;
			}
			repaint();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			monkey.monkeyState = new Moving();
			monkey.monkeyState.idle(monkey);
			repaint();
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
		  
	}
}