
public class Wheel
{
	int radius;
	String weather;
	
	public Wheel(int rad, String weat)
	{
		setRadius(rad);
		setWeather(weat);
	}

	public void rotate()
	{
		System.out.println("Rotado 90°");
	}
	
	public void setRadius(int rad)
	{
		this.radius = rad;
	}
	
	public void setWeather(String weat)
	{
		this.weather = weat;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public String getWeather()
	{
		return weather;
	}
	
	
}
