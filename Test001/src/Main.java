import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hola \n");
		int x,y;
		Car mazda = new Car();
	
		Scanner scan = new Scanner(System.in);
		
		/*for(y=1;y!=0;y++)
		{
			System.out.println("Dame una velocidad: ");
			x = scan.nextInt();
			if(mazda.setVelocity(x))
		    {
		    System.out.println("Se establecio la velocidad.");
			System.out.println("La velocidad establecida es: "+mazda.getVelocity()+" km/h\n");
			y=-1;
			}
			else
				System.out.println("Intenta con valores menores a 200 km/hr ");
			
		}
		*/
		
		if(mazda.setWheels())
			System.out.println("Se establecieron las características de las llantas.");
		System.out.println("Las características de las llantas son: ");
		System.out.println("Numero de llantas es " +mazda.getWheels()[0].getRadius());
		System.out.println("El clima para este carro es " +mazda.getWheels()[0].getWeather());
		
		Family_car toyota = new Family_car();
		toyota.getTrunkSize();
		
		/*toyota.setVelocity(x);
		System.out.println("La velocidad establecida es: "+mazda.getVelocity()+"\n");
		toyota.setWheels();
		System.out.println("Las características de las llantas son: ");
		System.out.println("El radio de las llantas es " +toyota.getWheels()[0].getRadius());
		System.out.println("El clima para estas llantas es " +mazda.getWheels()[0].getWeather());*/
		
		/*for(int x=0;x<10;x++)
		{
			for(int y=0; y<(x+1); y++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}*/
	}

}
