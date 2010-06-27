package core;

import graphics.GraphicsUpdater;
import graphics.Gui;

import java.awt.Dimension;



public class Hex {

	static GameManager gameManager;
	static GraphicsUpdater graphicsUpdater;
	public static void main(String[] args) {
		System.out.println("Main::Initializing local GameUpdater");
		gameManager = new GameManager();
		System.out.println("Main::local GameUpdater Initialized");
		
		System.out.println("Main::Creating new Gui");
		Gui screen = new Gui("Hex Game Main Window",gameManager);
		screen.setSize(new Dimension(500,500));
		screen.setVisible(true);
		System.out.println("Main::Gui Created");
		
	}
}