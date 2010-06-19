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

import net.HexConnector;

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
	GuiUpdater guiUpdater;
	
	
	HexConnector connector; // Only here to test functionality -- should be in "game" class

	//Constructor
	public Gui(String s) {
		super(s); // construct Frame part of Gui	
		connector = new HexConnector();
		setLayout(new FlowLayout());
		
		quitButton = new Button("quit");
		add(quitButton);
		quitButton.addActionListener(this);
		
		hostName = new TextField("Enter Hostname");
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
		
		
		guiUpdater = new GuiUpdater(dataText,connector);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			if(e.getSource() == quitButton){
				connector.closeConnections();
				System.exit(0);
			}
			if(e.getSource() == joinButton){
				dataText.append("Attempting to join: " + hostName.getText() + " on port: " + portNum.getText());
				connector.setHosted(false);
				connector.launch(hostName.getText(), Integer.parseInt(portNum.getText()));
				guiUpdater.start();
			}
			if(e.getSource() == hostButton){
				dataText.append("Waiting for connection on port: " + portNum.getText());
				connector.setHosted(true);
				connector.launch(hostName.getText(), Integer.parseInt(portNum.getText()));
				guiUpdater.start();
			}
			if((e.getSource() == sendButton)||((e.getSource() == sendText))){
				connector.send(sendText.getText());
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
