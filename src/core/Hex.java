package core;

import java.awt.Dimension;

import game.Game;
import graphics.Gui;



public class Hex {

	static Game game;
	public static void main(String[] args) {
		game = new Game();
		Gui screen = new Gui("Hex Game Main Window",game);
		screen.setSize(new Dimension(500,500));
		screen.setVisible(true);
		

	}
}