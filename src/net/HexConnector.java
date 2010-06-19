package net;

/*
 * This is the connector object, it is instantiated once the game is run.
 * It is meant to serve as a tunnel between clients.
 * 
 * 
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.net.Inet4Address;

public class HexConnector {
	SocketAction MyConnection;
	ServerSocket MyServerSocket;
	Socket MySocket;
	boolean isHosted;

	public HexConnector() {
		
	}

	public void setHosted(boolean isHosted){
		this.isHosted = isHosted;
	}
	public boolean launch(String name, int portNumber) {
		if (!isHosted) {
			try {

				MySocket = new Socket(name, portNumber,InetAddress.getLocalHost(),12367);
				MyConnection = new SocketAction(MySocket);
				MyConnection.start();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} else {
			try {
				MyServerSocket = new ServerSocket(portNumber);
				MySocket = MyServerSocket.accept();
				MyConnection = new SocketAction(MySocket);
				MyConnection.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
		return true;
	}

	public void send(String s) {
		MyConnection.send(s);
	}

	public String receive() throws IOException {
		return MyConnection.receive();
	}

	public void closeConnections() {
		MyConnection.closeConnections();
	}

	public boolean isConnected() {
		return MyConnection.isConnected();
	}

	protected void finalize() {
		MyConnection.finalize();
	}

}
