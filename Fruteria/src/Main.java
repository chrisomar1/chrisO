import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.List;

@SuppressWarnings("unused")
@Deprecated
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Refrigerador refri = new Refrigerador();
		refri.setTemperatura(4);
		CajaFrutas cajaFrutas = new CajaFrutas();
		Papaya papaya = new Papaya();
		papaya.setExpiracion(5);
		Sandia sandia = new Sandia();
		sandia.setExpiracion(7);
		Banana banana = new Banana();
		banana.setExpiracion(3);
		Papaya[] papayas = new Papaya[4];
		
		ArrayList <Papaya> listaPapaya = new ArrayList<Papaya>();
		listaPapaya.add(papaya);
		
		for(int x = 0; x < 1000; x++)
		{
			listaPapaya.add(papaya);
		}
		
		listaPapaya.remove(999);
		System.out.println("El numero es: "+listaPapaya.get(999).getSemillas());
		

		//listaPapaya.add(sandia);
		
		//Lista de Frutas
		ArrayList<Frutas> listaFrutas = new ArrayList<Frutas>();
		/*listaFrutas.add(banana);
		listaFrutas.add(papaya);
		listaFrutas.add(sandia);*/
		
		
		
		/*Sandia[] sandias = new Sandia[5];
		Banana[] bananas = new Banana[3];
		
		for(int x=0;x<papayas.length;x++)
		{
			papayas[x]=papaya;
		}
		
		for(int y=0;y<sandias.length;y++)
		{
			sandias[y]=sandia;
		}
		
		for(int z=0;z<bananas.length;z++)
		{
			bananas[z]=banana;
		}
		
		cajaFrutas.bananas = bananas;
		cajaFrutas.papayas = papayas;
		cajaFrutas.sandias = sandias;
		
		refri.setCajaFruta(cajaFrutas);
		/*for(int i=0; i<refri.getCajaFruta().papayas.length;i++)
		{
			System.out.println(refri.getCajaFruta().papayas[i].getExpiracion());
		}*/
		
		/*System.out.println("Las fechas de expiración de las papayas son:");
		for(int i=0; i<refri.getCajaFruta().getPapayas().length;i++)
		{
			System.out.println("Papaya "+(i+1)+": en "+refri.getCajaFruta().getPapayas()[i].getExpiracion()+" dias.");
		}
		
		System.out.println("\nLas fechas de expiración de las sandias son:");
		for(int i=0; i<refri.getCajaFruta().getSandia().length;i++)
		{
			System.out.println("Sandia "+(i+1)+": en "+refri.getCajaFruta().getSandia()[i].getExpiracion()+" dias.");
		}
		
		System.out.println("\nLas fechas de expiración de las bananas son:");
		for(int i=0; i<refri.getCajaFruta().getBanana().length;i++)
		{
			System.out.println("Banana "+(i+1)+": en "+refri.getCajaFruta().getBanana()[i].getExpiracion()+" dias.");
		}
		
		System.out.println("Tamaño de listaPapaya: "+listaPapaya.size());
		
		/*for(int x = 0; x < listaPapaya.size(); x++)
		{
			System.out.println(listaPapaya.get(x).getExpiracion());
		}*/
		
		/*System.out.println("\n");
		
		Iterator<Papaya> itr = listaPapaya.iterator(); //Agregar el tipo de dato de la lista.
		
		/*while(itr.hasNext())
		{
			System.err.println(itr.next().getExpiracion());
		}*/
		
		/*Vector<Frutas> miVector = new Vector(100);
		
		miVector.add(papaya);
		miVector.add(papaya);
		miVector.add(sandia);
		
		Enumeration<Frutas> en = miVector.elements();
		
		/*while(en.hasMoreElements())
		{
			System.err.println("Fruta :"+en.nextElement().getExpiracion());
		}
		*/
		/*Vector<Papaya> vPapaya = new Vector(100);
		
		vPapaya.add(papaya);
		vPapaya.add(papaya);
		vPapaya.add(papaya);
		
		Enumeration<Papaya> ePapaya = vPapaya.elements();
		
		/*while(ePapaya.hasMoreElements())
		{
			System.err.println("Papaya :"+ePapaya.nextElement().getExpiracion());
		}*/
		
		/*HashMap<Integer, String> miTabla = new HashMap<Integer, String>();
		miTabla.put(100, "Chana");
		miTabla.put(101, "Juana");
		miTabla.put(102, "Chona");
		miTabla.put(103, "Primitivo");
		/*
		for(Map.Entry entry: miTabla.entrySet())
		{
			System.out.println("Entrada "+entry.getKey()+" : "+entry.getValue());
		}*/
		
		
		//HASHTABLE NO ACEPTA VALORES NULOS O DUPLICADOS AL CONTRARIO DEL HASHMAP.
		/*Hashtable<Integer,String> hashTable = new Hashtable<Integer, String>();
		hashTable.put(1000, "Chana");
		hashTable.put(101, "Juana");
		hashTable.put(1020, "Chona");
		hashTable.put(103, "Primitivo");
		
		for(Map.Entry miEntry:hashTable.entrySet())
		{
			System.out.println("Llave : "+miEntry.getKey()+", Valor : "+miEntry.getValue());
		}*/
		
		/*Scanner lector = new Scanner(System.in);
		System.out.println("Ingrese algo: ");
		int algo = lector.nextInt();
		
		assert algo >= 60:"Estás chavo";
		System.out.println("Valor de algo: "+algo);*/
		
		/*for(MiEnum miEnum: MiEnum.values())
		{
			System.out.println("MiEnum : "+miEnum);
		}*/
		
		//Sin Lambda.
		
		Clavija miClavija = new Clavija()
				{

					@Override
					public void contectarse() {
						// TODO Auto-generated method stub
						System.out.println("Clavija 1!!!!");
						
					}
					
				}; //Clase anónima.
				miClavija.contectarse();
				
				//Con Lambda
				Clavija miClavija2 = ()->{
					
					System.out.println("\nClavija 2!!!!");
				};
				
				miClavija2.contectarse();
				
				//Otra Lambda
				
				OtraClase otraClase = (algo)->
				{
					return algo;
				};
				
				System.out.println("\nOtra clase "+otraClase.loQueSea("MI CADENA"));
				
				Papaya papaya = new Papaya();
				ArrayList <Papaya> listaPapaya = new ArrayList<Papaya>();
				listaPapaya.add(papaya);
				
				for(int x = 0; x < 1000; x++)
				{
					listaPapaya.add(papaya);
				}
				
				listaPapaya.forEach(
						
						n->{
							System.out.println(n.getExpiracion());
							System.out.println(n.getColor());
							
						}
						
						);
				
				listaPapaya.forEach((Papaya n)->{
					
					System.out.println(n.getExpiracion());
					System.out.println(n.getColor());
				});
				
				List<Producto> listaProducto = new ArrayList<Producto>();
				listaProducto.add(new Producto(1,"Banana",12));
				listaProducto.add(new Producto(2,"Papaya",10));
				listaProducto.add(new Producto(3,"Berenjena",15));
				Collections.sort(listaProducto,(p1,p2)->{
					
					//return p1.nombre.compareTo(p2.nombre);
					return String.valueOf(p1.precio).compareTo(String.valueOf(p2.precio));
				});
				
				for(Producto p:listaProducto)
				{
					System.out.println("Producto"+p.id+" : "+p.nombre+" : "+p.precio);
				}
	}
	
	public enum MiEnum
	{
		LUNES,
		MARTES,
		MIERCOLES,
		JUEVES,
		VIERNES,
		SABADO,
		DOMINGO
	}
	
	

}
