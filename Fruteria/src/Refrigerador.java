
public class Refrigerador implements Clavija
{
	
	private int temperatura;
	private CajaFrutas cajaFruta;
	int voltaje;
	
	public Refrigerador()
	{
		
	}
	
	public void setTemperatura(int temp)
	{
		this.temperatura = temp;
	}
	
	public int getTemperatura()
	{
		return temperatura;
	}
	
	public void setCajaFruta(CajaFrutas cajaFruta)
	{
		this.cajaFruta = cajaFruta;
	}
	
	public CajaFrutas getCajaFruta()
	{
		return this.cajaFruta;
	}

	@Override   //Sobreescribir lo que hay adentro
	public void contectarse() {
		// TODO Auto-generated method stub
		voltaje = 220;
		
	}

	/*@Override
	public String loQueSea(String algo) {
		// TODO Auto-generated method stub
		return null;
	}*/
	

}
