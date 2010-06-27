package game;

import java.io.Serializable;
import java.util.Vector;

public class Player implements Serializable
{
	private static final long serialVersionUID = 0L;
	private int playerID;
	private String name;
	private float money;
	private Vector<Ship> ships;
	
	public Player() {}
	
	public Player( int id, String name )
	{
		this.playerID = id;
		this.name = name;
		this.money = 0;
	}
	
	public Player( int id, String name, float money )
	{
		this.playerID = id;
		this.name = name;
		this.money = money;
	}
	
	public int getPlayerID()
	{
		return this.playerID;
	}
	
	public String getPlayerName()
	{
		return this.name;
	}
	
	public float getMoney()
	{
		return this.money;
	}
	
	public void addShip( Ship ship )
	{
		ships.add( ship );
	}
	
	public boolean removeShip( Ship ship )
	{
		return false;
	}

	public void setShips( Vector<Ship> ships )
	{
		this.ships = ships;
	}

	public Vector<Ship> getShips()
	{
		return ships;
	}
}