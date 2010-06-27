package net;

import game.Game;
import java.io.IOException;

import core.GameManager;

public class IncomingDataHandler extends Thread {
	HexConnecter hexConnecter;
	GameManager gameManager;

	public IncomingDataHandler(GameManager gameUpdater, HexConnecter connector) {
		this.gameManager = gameUpdater;
		this.hexConnecter = connector;
	}

	public void run() {
		while (hexConnecter.isConnected()) {
			try {
				System.out.println("IncomingDataHandler:run:Waiting for data:");
				gameManager.setGame((Game) hexConnecter.receive());
				if (gameManager.getGame() == null) {
					System.out.println("IncomingDataHandler::IncomingGame is null");
					throw new IOException();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.exit(1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("IncomingDataHandler::Data Received");
		}
	}

}
