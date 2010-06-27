package game;

import java.io.Serializable;
public class Game implements Serializable {
	/**
	 * This is the big one;
	 */
	private static final long serialVersionUID = 1L;
	private int MyNum;
	private String MyString;
	
	private int activePlayerID = 0;
	
	public Game(){}
	
	public Game(int i, String s)
	{
		this.MyNum = i;
		this.setMyString(s);
	}
	
	public int getInt()
	{
		return this.MyNum;
	}
	
	public void setMyString(String myString)
	{
		MyString = myString;
	}
	
	public String getMyString()
	{
		return MyString;
	}
	
	public int getActivePlayerID()
	{
		return activePlayerID;
	}
}
