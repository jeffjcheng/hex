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

import core.GameUpdater;

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
	TextArea dataText;
	
	GameUpdater gameUpdater;
	GraphicsUpdater graphicsUpdater;
	
	
	

	//Constructor
	public Gui(String s, GameUpdater gameUpdater) {
		super(s); // construct Frame part of Gui	
		this.gameUpdater = gameUpdater;
		this.graphicsUpdater = new GraphicsUpdater(gameUpdater);
		
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
				gameUpdater.CloseConnections();
				System.exit(0);
			}
			if(e.getSource() == joinButton){
				dataText.append("Gui::Join Button Clicked");
				if(gameUpdater.JoinGame(hostName.getText(),Integer.parseInt(portNum.getText()))){
					this.dataText.append("Game joined successfully");
					this.joinButton.setEnabled(false);
					this.hostButton.setEnabled(false);
				}else{
					this.dataText.append("Joining game failed!");
				}
			}
			if(e.getSource() == hostButton){
				System.out.println("Gui::Host Button Clicked");
				if(gameUpdater.HostGame(hostName.getText(), Integer.parseInt(portNum.getText()))){
					this.dataText.append("Game Hosted Successfully");
					this.joinButton.setEnabled(false);
					this.hostButton.setEnabled(false);
				}else{
					this.dataText.append("Game Host Failed!");
				}
				
				
			}
			if((e.getSource() == sendButton)||((e.getSource() == sendText))){
				gameUpdater.SendText(sendText.getText());
				dataText.append(sendText.getText() + "\n");
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
