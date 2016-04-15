package com.tirumala;

public class Idle extends State {
		
	public State moveLeft(Monkey monkey){
		monkey.monkeyState=new Moving();
		monkey.moveLeft();
		System.out.println("going to moving");
		return monkey.monkeyState;
	}
	public State moveRight(Monkey monkey){
		monkey.monkeyState=new Moving();
		monkey.moveRight();
		System.out.println("going to moving");
		return monkey.monkeyState;
	}
	public State moveUp(Monkey monkey){
		monkey.monkeyState=new Moving();
		monkey.moveUp();
		System.out.println("going to moving");
		return monkey.monkeyState;
	}
	public State moveDown(Monkey monkey){
		monkey.monkeyState=new Moving();
		monkey.moveDown();
		System.out.println("going to moving");
		return monkey.monkeyState;
	}
}
