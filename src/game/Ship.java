package game;

import java.io.Serializable;

public class Ship implements Serializable
{
	private static int shipIDCounter = 0;
	private static final long serialVersionUID = 2L;
	private Object owner;
	private int shipID;
	private float
		money,
		heat,
		velocity;
	
	public Ship()
	{
		shipID = Ship.shipIDCounter++;
	}

	public void setOwner( Object owner )
	{
		this.owner = owner;
	}

	public Object getOwner()
	{
		return owner;
	}

	public void setMoney( float money )
	{
		this.money = money;
	}

	public float getMoney()
	{
		return money;
	}

	public void setHeat( float heat )
	{
		this.heat = heat;
	}

	public float getHeat()
	{
		return heat;
	}

	public void setVelocity( float velocity )
	{
		this.velocity = velocity;
	}

	public float getVelocity()
	{
		return velocity;
	}

	public int getShipID()
	{
		return shipID;
	}
}