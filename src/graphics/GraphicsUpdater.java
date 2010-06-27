package graphics;

import core.GameUpdater;

/*
 * This class/Thread handles the drawing of the main in-game UI
 * 
 * It spools around, and draws the game, based on the game object.
 * Later, it will detect changes to the game object, and animate them as necessary.
 */
public class GraphicsUpdater extends Thread {

	GameUpdater gameUpdater;
	public GraphicsUpdater(GameUpdater gameUpdater){
		this.gameUpdater = gameUpdater;
	}
}
