package graphics;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import core.GameManager;

/*
 * This is the primary pre-game UI. It also handles mouse events and passes them into the Game Updater.
 */
public class Gui extends Frame implements WindowListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Button sendButton;
	Button quitButton;
	Button hostButton;
	Button joinButton;
	TextField hostName;
	TextField portNum;
	TextField sendText;
	public TextArea dataText;
	
	GameManager gameManager;
	GraphicsUpdater graphicsUpdater;
	
	
	

	//Constructor
	public Gui(String s, GameManager gameUpdater) {
		super(s); // construct Frame part of Gui	
		this.gameManager = gameUpdater;
		this.graphicsUpdater = new GraphicsUpdater(gameUpdater,this);
		
		setLayout(new FlowLayout());
		
		quitButton = new Button("quit");
		add(quitButton);
		quitButton.addActionListener(this);
		
		hostName = new TextField("localhost");
		add(hostName);
		
		portNum = new TextField("4444");
		add(portNum);
		
		joinButton = new Button("Join");
		add(joinButton);
		joinButton.addActionListener(this);
		
		hostButton = new Button("Host");
		add(hostButton);
		hostButton.addActionListener(this);
		
		dataText = new TextArea("");
		add(dataText);
		
		sendText = new TextField("Enter Text Here");
		add(sendText);
		sendText.addActionListener(this);
		
		sendButton = new Button("Send");
		add(sendButton);
		sendButton.addActionListener(this);
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			if(e.getSource() == quitButton){
				gameManager.CloseConnections();
				System.exit(0);
			}
			if(e.getSource() == joinButton){
				System.out.println("Gui::Join Button Clicked");
				this.dataText.append("\nTrying to join game on @ " + hostName.getText() + ":" + Integer.parseInt(portNum.getText()));
				if(gameManager.JoinGame(hostName.getText(),Integer.parseInt(portNum.getText()))){
					this.dataText.append("\nGame joined successfully");
					graphicsUpdater.start();
					this.joinButton.setEnabled(false);
					this.hostButton.setEnabled(false);
				}else{
					this.dataText.append("\nJoining game failed!");
				}
			}
			if(e.getSource() == hostButton){
				System.out.println("Gui::Host Button Clicked");
				this.dataText.append("\nTrying to host game on port: " + Integer.parseInt(portNum.getText()));
				if(gameManager.HostGame(hostName.getText(), Integer.parseInt(portNum.getText()))){
					this.dataText.append("\nGame Hosted Successfully");
					graphicsUpdater.start();
					this.joinButton.setEnabled(false);
					this.hostButton.setEnabled(false);
				}else{
					this.dataText.append("\nGame Host Failed!");
				}
				
				
			}
			if((e.getSource() == sendButton)||((e.getSource() == sendText))){
				gameManager.SendText(sendText.getText());
				sendText.setText("");
			}
	}


	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}


	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}


	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	// define action for Button press

}
