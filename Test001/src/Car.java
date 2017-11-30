
public class Car 
{
	int velocity;
	Wheel[] llanta  = new Wheel[5];
	
	public Car()
	{
		
	}
	
	public boolean setVelocity(int km)
	{
		if(km>200)
		{
			System.out.println("Te manchaste con la velocidad");
			return false;
		}
			
		velocity = km;
		return true;
	}
	
	public int getVelocity()
	{
		return velocity;
	}
	
	public boolean setWheels()
	{
		llanta[0] = new Wheel(4,"Warm");
		
		
		return true;
	}
	
	public Wheel[] getWheels()
	{
		return llanta;
	}

}
