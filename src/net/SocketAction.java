package net;
// SocketAction Class
// SocketAction.java

// All code graciously developed by Greg Turner. You have the right
// to reuse this code however you choose. Thanks Greg!

// Imports
import java.net.*;
import java.io.*;

class SocketAction extends Thread {
  private ObjectInputStream inStream = null;
  private ObjectOutputStream   outStream = null;
  private Socket          socket = null;

  public SocketAction() {}
  public SocketAction(Socket sock) {
    //super("SocketAction");
	  socket = sock;
    try {
    	
    	//Java is evil...
      outStream = new ObjectOutputStream(socket.getOutputStream());
      InputStream preInStream = socket.getInputStream();
      inStream = new ObjectInputStream(preInStream);
      System.out.println("SocketAction::ObjectStreams Created");
      
    }
    catch (IOException e) {
      System.out.println("Couldn't initialize SocketAction: " + e);
      System.exit(1);
    }
  }

  public void run() {
  }

  public void send(Object s) {
    //outStream.println(s);
	  try {
		outStream.writeObject(s);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  public Object receive() throws IOException, ClassNotFoundException {
    //return inStream.readLine();
	  return inStream.readObject();
  }

  public void closeConnections() {
    try {
      socket.close();
      socket = null;
    }
    catch (IOException e) {
      System.out.println("Couldn't close socket: " + e);
    }
  }

  public boolean isConnected() {
	  System.out.println("SocketAction::IsConnected Called");
    return ((inStream != null) && (outStream != null) &&
      (socket != null));
    }

  protected void finalize () {
    if (socket != null) {
      try {
        socket.close();
      }
      catch (IOException e) {
        System.out.println("Couldn't close socket: " + e);
      }
      socket = null;
    }
  }
}