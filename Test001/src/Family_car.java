
public class Family_car extends Car
{
	String trunkSize;
	
	public Family_car()
	{
		setTrunkSize();
	}
	
	public void setTrunkSize()
	{
		trunkSize = "Grande"; 
	}
	
	public void getTrunkSize()
	{
		System.out.println("El tamaño del carro es: "+trunkSize);
		
	}

}
