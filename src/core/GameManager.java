package core;

import game.Game;
import net.HexConnecter;
import net.IncomingDataHandler;

/*
 * This class/Thread is responsible for updating the Game state based on various events
 * 
 * It handles mouse events, passed in as function calls
 * It also handles changes to the game state, also passed in as a function call
 */
public class GameManager{

	IncomingDataHandler incomingDataHandler;
	HexConnecter hexConnecter;
	Game game;
	boolean isUpdated = false;
	
	
	public GameManager(){
		this.game = new Game();
		hexConnecter = new HexConnecter();
		this.incomingDataHandler = new IncomingDataHandler(this,hexConnecter);
	}
	public void CloseConnections(){
		hexConnecter.closeConnections();
	}
	public boolean JoinGame(String hostName, int portNumber) {
		this.hexConnecter.setHosted(false);
		if(this.hexConnecter.launch(hostName, portNumber))
		{
			this.incomingDataHandler.start();
			return true;
		}
		return false;
	}	
	public boolean HostGame(String hostName, int portNumber) {
		this.hexConnecter.setHosted(true);
		if(this.hexConnecter.launch(hostName, portNumber)){
			
			this.incomingDataHandler.start();
			return true;
		}
		return false;
	}
	
	
	public void SendText(String text){
		game.setMyString(text);
		hexConnecter.send(game);
		this.isUpdated = true;
	}
	
	public void setGame(Game game) { //This is ONLY ever called by the IncomingDataHandler... or by a load game of some sort.
		this.game = game;
		this.isUpdated = true;
	}
	public Game getGame() {
		return game;
	}
	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}
	public boolean isUpdated() {
		return isUpdated;
	}
}
