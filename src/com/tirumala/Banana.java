package com.tirumala;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Banana {

	private int bX, bY;
	public Banana(int x, int y, int tileSize){
		this.bX=x;
		this.bY=y;
	}
	
	public void draw(Graphics g){
		Image banana = new ImageIcon(this.getClass().getResource("/resources/banana.png")).getImage();
		g.drawImage(banana, bX*Screen.tileSize, bY*Screen.tileSize, Screen.tileSize, Screen.tileSize, null);
	}
	
	public int getbX(){
		return bX;
	}
	
	public int getbY(){
		return bY;
	}
	
	public void setbX(int x){
		this.bX = x;
	}
	
	public void setbY(int y){
		this.bY = y;
	}
}
