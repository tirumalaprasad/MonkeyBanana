package com.tirumala;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Monkey  {
	
	public State monkeyState;
	public int mX, mY, width, height;
	
	public Monkey(int x,int y,int tilesize){
		this.mX=x;
		this.mY=y;
		width=tilesize;
		height=tilesize;
		monkeyState= new Idle();
	}

	
	
	public void draw(Graphics g){
		/*g.setColor(Color.BLACK);
		g.fillRect(mX*width, mY*width, width, height);
		g.setColor(Color.BLUE);
		g.fillRect(mX*width+2, mY*width+2, width, height);*/
		Image img = new ImageIcon(this.getClass().getResource("/resources/monkey.png")).getImage();
		g.drawImage(img, mX, mY, Screen.tileSize, Screen.tileSize, null);
	}
	
	void moveLeft(){
		monkeyState = monkeyState.moveLeft(this);
	}
	void moveRight(){
		monkeyState = monkeyState.moveRight(this);
	}
	void moveUp(){
		monkeyState = monkeyState.moveUp(this);
	}
	void moveDown(){
		monkeyState = monkeyState.moveDown(this);
	}
	void idle(){
		monkeyState = monkeyState.idle(this);
	}
	
	public int getmX(){
		return mX;
	}
	public void setmX(int x) {
		this.mX= x;
	}
	public int getmY(){
		return mY;
	}
	public void setmY(int y) {
		this.mY= y;
	}
}
