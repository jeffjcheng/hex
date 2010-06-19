package net;
// SocketAction Class
// SocketAction.java

// All code graciously developed by Greg Turner. You have the right
// to reuse this code however you choose. Thanks Greg!

// Imports
import java.net.*;
import java.io.*;

class SocketAction extends Thread {
  private DataInputStream inStream = null;
  protected PrintStream   outStream = null;
  private Socket          socket = null;

  public SocketAction(Socket sock) {
    super("SocketAction");
    try {
      inStream = new DataInputStream(new
        BufferedInputStream(sock.getInputStream(), 1024));
      outStream = new PrintStream(new
        BufferedOutputStream(sock.getOutputStream(), 1024), true);
      socket = sock;
    }
    catch (IOException e) {
      System.out.println("Couldn't initialize SocketAction: " + e);
      System.exit(1);
    }
  }

  public void run() {
  }

  public void send(String s) {
    outStream.println(s);
  }

  public String receive() throws IOException {
    return inStream.readLine();
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