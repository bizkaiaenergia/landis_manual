


	import java.io.*;
import java.util.Properties;
public class propiedades {
	
	
	String archivo_properties="landis.properties";
	
	
	String ruta_archivo_landis;
	String ruta_archivo_pi_ufl;
	String minutos_generacion;
	
	Properties prop  = new Properties();
	
	String ruta_archivo_landis(){
			try{
				prop.load(new FileInputStream(archivo_properties));
				ruta_archivo_landis = prop.getProperty("ruta_archivo_landis");
			}catch(IOException e){
			}
			return ruta_archivo_landis;
			}
	String ruta_archivo_pi_ufl(){
		try{
			prop.load(new FileInputStream(archivo_properties));
			ruta_archivo_pi_ufl = prop.getProperty("ruta_archivo_pi_ufl");
		}catch(IOException e){
		}
		return ruta_archivo_pi_ufl;
		}
	
	String minutos_generacion(){
		try{
			prop.load(new FileInputStream(archivo_properties));
			minutos_generacion = prop.getProperty("minutos_generacion");
		}catch(IOException e){
		}
		return minutos_generacion;
		}
	
	
	
	
	
	
	
}