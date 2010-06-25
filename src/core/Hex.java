package core;

import java.awt.Dimension;

import game.Game;
import graphics.Gui;



public class Hex {

	static Game game;
	public static void main(String[] args) {
		System.out.println("Main::Program Started, initializing local static Game");
		game = new Game();
		System.out.println("Main::Local static Game Created");
		
		System.out.println("Main::Creating new Gui");
		Gui screen = new Gui("Hex Game Main Window",game);
		screen.setSize(new Dimension(500,500));
		screen.setVisible(true);
		

	}
}