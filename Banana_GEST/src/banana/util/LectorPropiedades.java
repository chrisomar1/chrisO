package banana.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class LectorPropiedades //Estará presente en todo el dominio de la aplicación y no se necesitará instancia por el final.
{
	private InputStream inputStream;
	
	public final Properties getPropValues() throws IOException
	{
		Properties properties = null;
		try{
			properties = new Properties();
			String file = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(file);
			
			if(inputStream != null)
			{
				properties.load(inputStream);
			}
			else
			{
				throw new FileNotFoundException("Archivo de configuración '"+file+"' no encontrado en classpath.");
			}
			
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			inputStream.close();
		}
		return properties;
	}

}
