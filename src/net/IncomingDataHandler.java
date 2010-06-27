package net;

import game.Game;
import java.io.IOException;

import core.GameUpdater;

public class IncomingDataHandler extends Thread{
	HexConnecter hexConnecter;
	GameUpdater gameUpdater;
	Game game;
	public IncomingDataHandler(GameUpdater gameUpdater, Game game, HexConnecter connector){
		this.gameUpdater = gameUpdater;
		this.hexConnecter = connector;
		this.game = game;
	}
	
	public void run(){
			while (hexConnecter.isConnected()){
				try {
					gameUpdater.UpdateGame((Game)hexConnecter.receive());
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
	
}
