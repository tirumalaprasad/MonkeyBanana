package com.tirumala;

import java.awt.GridLayout;
import com.tirumala.Screen;
import javax.swing.JFrame;

public class Wonderland extends JFrame {

	private static final long serialVersionUID = 1L;
	public Screen s = new Screen();
	public Wonderland(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Monkey Banana");
		setResizable(false);
		init();
		
	}
	
	public void init(){
		setLayout(new GridLayout(1, 1, 0, 0));
		add(s);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
