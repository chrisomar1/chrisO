import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce n: ");
		int numero1 = scan.nextInt();
		System.out.println("Introduce m: ");
		int numero2 = scan.nextInt();
		int resultado = differentValuesInMultiplicationTable(numero1,numero2);
		System.out.println("El numero de numeros diferentes dentro de la matriz es: "+resultado);
		
		/*String str1 = "uno";
		String str2 = "dos";
		System.out.println(str1.equals(str1=str2));*/
		
		/*char c;
		int i;
		c='a';
		i=c;
		//i++;
		c=(char)i;
		System.out.println(c);*/
		
	}
	
    public static int differentValuesInMultiplicationTable(int n, int m) {
		    
    	int comparador = 0;
    	int [] multiplica = new int[(m+1)*(n+1)];
    	int contador = 0;
    	
    	for(int x=0; x<=n; x++)
    		for(int y=0; y<=m;y++)
    		{
    			multiplica[contador] = x*y;
    			//System.out.println(multiplica[contador]);
				contador++;
    		}
    	
    	Arrays.sort(multiplica);
    	
    	contador = 0;
    	
    	for(int x = 0; x<multiplica.length; x++)
    	{
    		//System.out.println(multiplica[x]);
    		if(comparador!=multiplica[x])
    		{
    			contador++;
    			comparador = multiplica[x];
    			//System.out.println("contador: "+contador);
    		}
    	}
    		
    	return contador;
		}

}
