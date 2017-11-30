
public class Crossover extends Car
{
	int suspensionHeight;
	
	public Crossover()
	{
		setSuspensionHeight();
	}
	
	public void setSuspensionHeight()
	{
		suspensionHeight = 120;
	}
	
	public void getSuspensionHeight()
	{
		System.out.println("La altura de la suspensión es: "+suspensionHeight);
		
	}

}
