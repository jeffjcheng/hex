package graphics;

import java.awt.TextArea;
import java.io.IOException;

import net.HexConnector;

public class GuiUpdater extends Thread{
TextArea dataText;
HexConnector connector;
	public GuiUpdater(TextArea dataText, HexConnector connector){
		this.dataText = dataText;
		this.connector = connector;
	}
	
	public void run(){
			while (connector.isConnected()){
				String data;
				try {
					data = connector.receive();
					if(data == null){break;}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					data = "Connection closed";
				}
				updateText(data + "\n");
				System.out.println("Data Received: " + data);
			}
	}
	
	synchronized void updateText(String s){
		dataText.append(s);
	}
}
