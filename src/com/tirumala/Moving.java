package com.tirumala;

public class Moving extends State {

	public State moveLeft(Monkey monkey){
		System.out.println("Im moving left");
		monkey.mX -= Screen.tileSize;
		monkey.setmX(monkey.mX);
		System.out.println("x coordinate "+monkey.mX);
		System.out.println("going to moving");
		return new Moving();
	}
	public State moveRight(Monkey monkey){
		System.out.println("Im moving right");
		monkey.mX += Screen.tileSize;
		monkey.setmX(monkey.mX);
		System.out.println("x coordinate "+monkey.mX);
		System.out.println("going to moving");
		return new Moving();
	}
	public State moveUp(Monkey monkey){
		System.out.println("Im moving up");
		monkey.mY -= Screen.tileSize;
		monkey.setmY(monkey.mY);
		System.out.println("y coordinate "+monkey.mY);
		System.out.println("going to moving");
		return new Moving();
	}
	public State moveDown(Monkey monkey){
		System.out.println("Im moving down");
		monkey.mY += Screen.tileSize;
		monkey.setmY(monkey.mY);
		System.out.println("going to moving");
		return new Moving();
	}
	
	public State idle(Monkey monkey){
		System.out.println("going to idle");
		return new Idle();
	}
}
