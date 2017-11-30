import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//leerArchivo("C:/Users/ChristianOmar/Documents/prueba.txt");
		//leerArchivoManual("C:/Users/ChristianOmar/Documents/prueba.txt");
		escribirArchivo("C:/Users/ChristianOmar/Documents/prueba2.txt");

	}
	
	public static void escribirArchivo(String archivo)
	{
		String [] datos = {"Qué ", " Pedro ", " Juan."};
		
		//PrintWriter miPrintWriter;
		try {
			PrintWriter miPrintWriter = new PrintWriter(
					new BufferedWriter(new FileWriter(archivo)));
			//int lineaC = 1;
			for(int i = 0; i < datos.length; i++)
			{
				miPrintWriter.println(datos[i]);
			}
			
			miPrintWriter.close();
			System.out.println("Hecho...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void leerArchivoManual (String archivo)
	{
		int nLinea = 0;
		try {
			BufferedReader bfrd = new BufferedReader(
					new FileReader(archivo));
			String s = new String();
			Scanner lector = new Scanner(System.in);
			System.out.println("Ingrese una línea: ");
			int nLinea2 = lector.nextInt();
			
			while((s = bfrd.readLine()) != null)
			{
				nLinea++;
				if(nLinea2 == (nLinea))
				{
					System.out.println((nLinea)+" : "+s);
				}
				
				
			}
				
			
			bfrd.close(); //Siempre cerrar el buffer.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void leerArchivo (String archivo)
	{
		int nLinea = 0;
		try {
			BufferedReader bfrd = new BufferedReader(
					new FileReader(archivo));
			String s = new String();
			String s2 = new String();
			while((s = bfrd.readLine()) != null)
			{
				System.out.println((nLinea+1)+" : "+s);
				nLinea++;
			}
			bfrd.close(); //Siempre cerrar el buffer.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
