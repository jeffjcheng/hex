package graphics;

import core.GameManager;

/*
 * This class/Thread handles the drawing of the main in-game UI
 * 
 * It spools around, and draws the game, based on the gameManager object.
 * Later, it will detect changes to the game object, and animate them as necessary.
 */
public class GraphicsUpdater extends Thread {

	GameManager gameManager;
	Gui guiParent;

	public GraphicsUpdater(GameManager gameUpdater, Gui guiParent) {
		this.gameManager = gameUpdater;
		this.guiParent = guiParent;
	}

	public void run() {
		//for now, this just runs every second, then checks with the game manager to see if there has been an update
		// If there has been, it draws and then resets the updated state of the game manager.
		while (true) {
			try {
				Thread.sleep(1000);
				this.draw();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private void draw(){
		if(gameManager.isUpdated()){
			gameManager.setUpdated(false);
			guiParent.dataText.append("\n" + gameManager.getGame().getMyString());
		}
	}
}
