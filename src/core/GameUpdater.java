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
public class GameUpdater extends Thread {

	IncomingDataHandler incomingDataHandler;
	HexConnecter hexConnecter;
	Game game;
	
	public GameUpdater(Game game){
		this.game = game;
		hexConnecter = new HexConnecter();
		this.incomingDataHandler = new IncomingDataHandler(this,game,hexConnecter);
	}
	public void run(){
		
	}
	public void CloseConnections(){
		hexConnecter.closeConnections();
	}
	public boolean JoinGame(String hostName, int portNumber) {
		this.hexConnecter.setHosted(false);
		if(this.hexConnecter.launch(hostName, portNumber))
		{
			this.incomingDataHandler.start();
			this.start();
			return true;
		}
		return false;
	}
	public boolean HostGame(String hostName, int portNumber) {
		this.hexConnecter.setHosted(true);
		if(this.hexConnecter.launch(hostName, portNumber)){
			this.incomingDataHandler.start();
			this.start();
			return true;
		}
		return false;
	}
	public void SendText(String text){
		game.setMyString(text);
		hexConnecter.send(game);
	}
	synchronized public void UpdateGame(Game game) {
		this.game = game;
		
	}
	
	
}
