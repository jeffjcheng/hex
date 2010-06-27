package game;

import java.io.Serializable;

public class Module implements Serializable
{
	private static int moduleIDCounter = 0;
	private static final long serialVersionUID = 3L;
	
	private Object owner;
	
	private int moduleID;
	private String name;
	private float
		structuralIntegrity,
		cost,
		upkeep;
	
	public Module()
	{
		this.moduleID = Module.moduleIDCounter++;
	}
	
	public Module( Object owner )
	{
		moduleID = Module.moduleIDCounter++;
		this.setOwner(owner);
	}

	public void setOwner(Object owner)
	{
		this.owner = owner;
	}

	public Object getOwner()
	{
		return owner;
	}
	
	public int getModuleID()
	{
		return moduleID;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setStructuralIntegrity( float structuralIntegrity )
	{
		this.structuralIntegrity = structuralIntegrity;
	}

	public float getStructuralIntegrity()
	{
		return structuralIntegrity;
	}

	public void setCost( float cost )
	{
		this.cost = cost;
	}

	public float getCost()
	{
		return cost;
	}

	public void setUpkeep( float upkeep )
	{
		this.upkeep = upkeep;
	}

	public float getUpkeep()
	{
		return upkeep;
	}
}