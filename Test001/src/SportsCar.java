
public class SportsCar 
{
	int aerodinamicalCoef;
	
	public SportsCar()
	{
		setAerodinamicalCoef();
	}
	
	public void setAerodinamicalCoef()
	{
		aerodinamicalCoef = 32;
	}
	
	public void getAerodinamicalCoef()
	{
		System.out.println("El coeficiente aerodinamico es: "+aerodinamicalCoef);
		
	}

}
