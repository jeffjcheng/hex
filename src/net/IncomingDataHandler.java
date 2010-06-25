package net;

import game.Game;
import java.io.IOException;

public class IncomingDataHandler extends Thread{
	HexConnector connector;
	Game game;
	public IncomingDataHandler(Game game, HexConnector connector){
		
		this.connector = connector;
		this.game = game;
	}
	
	public void run(){
			while (connector.isConnected()){
				try {
					game = (Game)connector.receive();
					if(game == null){break;}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Data Received: ");
				System.out.println(game.getMyString());
			}
	}
	
	/*synchronized void updateState(String s){
		dataText.append(s);
	}*/
}
