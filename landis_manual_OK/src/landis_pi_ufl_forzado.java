




import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;


public class landis_pi_ufl_forzado {
	public static String  ruta_archivo_landis;
	public static String  ruta_archivo_pi_ufl;
	
	public static String ultimo_bucle_generado ;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		propiedades Archivopropiedades = new propiedades();
		 ruta_archivo_landis = Archivopropiedades.ruta_archivo_landis();
		 ruta_archivo_pi_ufl = Archivopropiedades.ruta_archivo_pi_ufl();
		
		
		System.out.println("Importación ficheros sistema Landis a PI_UFL entre 2 fechas ");
		Scanner user_input = new Scanner( System.in );
		String Fecha_inicio;
		System.out.print("Introducir fecha inicio: [dd/MM/aaaa]");
		Fecha_inicio = user_input.next( );
		//user_input.close();
		String Fecha_fin;
		System.out.print("Introducir fecha final: [dd/MM/aaaa]");
		Fecha_fin = user_input.next( );
		user_input.close();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		Date fecha_inicio_date = null;
		Date fecha_fin_date = null;
		try {
			fecha_inicio_date = sdf.parse(Fecha_inicio);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fecha_fin_date = sdf.parse(Fecha_fin);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GregorianCalendar cal_fecha_inicio = new GregorianCalendar ();
		GregorianCalendar cal_fecha_fin = new GregorianCalendar ();
		cal_fecha_inicio.setTime(fecha_inicio_date);
		cal_fecha_fin.setTime(fecha_fin_date);
		
		Date Fecha_inicio_pirecalc = cal_fecha_inicio.getTime();
		
		while(cal_fecha_fin.after(cal_fecha_inicio)){	
			
			
			System.out.println("Se generarán los ficheros ...");
			
			Date Fecha = cal_fecha_inicio.getTime();
			Format formatter = new SimpleDateFormat("HH");
			String hora_actual= formatter.format(Fecha);
			formatter = new SimpleDateFormat("mm");
			String minutos_actual= formatter.format(Fecha);
			formatter = new SimpleDateFormat("dd");
			String dia_actual= formatter.format(Fecha);
			formatter = new SimpleDateFormat("yyyy");
			String año_actual= formatter.format(Fecha);
			formatter = new SimpleDateFormat("MM");
			String mes_actual= formatter.format(Fecha);
			
			ultimo_bucle_generado = año_actual + mes_actual + dia_actual + hora_actual + minutos_actual;
			
			String tag = "00001";
			final String datos_fichero1 = crear_fichero.landis(Fecha, tag, ruta_archivo_landis, ruta_archivo_pi_ufl);
			tag = "00002";
			 String datos_fichero2 = crear_fichero.landis(Fecha, tag, ruta_archivo_landis, ruta_archivo_pi_ufl);
			 tag = "00003";
			 String datos_fichero3 = crear_fichero.landis(Fecha, tag, ruta_archivo_landis, ruta_archivo_pi_ufl);
			 tag = "00004";
			 String datos_fichero4 = crear_fichero.landis(Fecha, tag, ruta_archivo_landis, ruta_archivo_pi_ufl);
			 tag = "00005";
			 String datos_fichero5 = crear_fichero.landis(Fecha, tag, ruta_archivo_landis, ruta_archivo_pi_ufl);
			 tag = "00006";
			 String datos_fichero6 = crear_fichero.landis(Fecha, tag, ruta_archivo_landis, ruta_archivo_pi_ufl);
			 
			 cal_fecha_inicio.add(Calendar.HOUR_OF_DAY,+1);
			
			 
		
		
		}
					try{	
					Thread.sleep(30000);
						
					Format formatter = new SimpleDateFormat("HH");
					String hora_inicial= formatter.format(Fecha_inicio_pirecalc);
					formatter = new SimpleDateFormat("mm");
					String minutos_inicial= formatter.format(Fecha_inicio_pirecalc);
					formatter = new SimpleDateFormat("dd");
					String dia_inicial= formatter.format(Fecha_inicio_pirecalc);
					formatter = new SimpleDateFormat("yy");
					String año_inicial= formatter.format(Fecha_inicio_pirecalc);
					formatter = new SimpleDateFormat("MMM",new Locale("us_US"));
					String mes_inicial=  formatter.format(Fecha_inicio_pirecalc);
					
				/*	
					 formatter = new SimpleDateFormat("HH");
					String hora_fin= formatter.format(Fecha_fin);
					formatter = new SimpleDateFormat("mm");
					String minutos_fin= formatter.format(Fecha_fin);
					formatter = new SimpleDateFormat("dd");
					String dia_fin= formatter.format(Fecha_fin);
					formatter = new SimpleDateFormat("yy");
					String año_fin= formatter.format(Fecha_fin);
					formatter = new SimpleDateFormat("MMM",new Locale("us_US"));
					String mes_fin=  formatter.format(Fecha_fin);
					*/
					
					
					
					
		
		
		
					Runtime rt = Runtime.getRuntime();
					Process pr1;
					
					//	pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=10CJA00DE100.XQ20,*-3h,*");
						pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=10CJA00DE100.XQ20," + dia_inicial+"-"+mes_inicial+"-"+año_inicial+",*");
					 
					System.out.println("cmd /c D://PI//bin//pirecalc /ex=10CJA00DE100.XQ20," + dia_inicial+"-"+mes_inicial+"-"+año_inicial+",*");
					BufferedReader input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
					String line=null;
					 while((line=input.readLine()) != null) {
		                    System.out.println(line); 
					 }
					 int exitVal;
					
						exitVal = pr1.waitFor();
					
					 System.out.println("Exited with error code "+exitVal); 
					 
					Process pr2 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=10CJA00DE100.XQ20I," + dia_inicial+"-"+mes_inicial+"-"+año_inicial+",*");
					System.out.println("cmd /c D://PI//bin//pirecalc /ex=10CJA00DE100.XQ20I," + dia_inicial+"-"+mes_inicial+"-"+año_inicial+",*"); 
					input = new BufferedReader(new InputStreamReader(pr2.getInputStream()));
					 line=null;
					 while((line=input.readLine()) != null) {
		                    System.out.println(line); 
					 }
					 exitVal = pr2.waitFor();
					 System.out.println("Exited with error code "+exitVal); 
					//System.out.println("b");
					Process pr3 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=FiscalMeter.TAG," + dia_inicial+"-"+mes_inicial+"-"+año_inicial+",*");
					System.out.println("cmd /c D://PI//bin//pirecalc /ex=FiscalMeter.TAG," + dia_inicial+"-"+mes_inicial+"-"+año_inicial+",*"); 
					 input = new BufferedReader(new InputStreamReader(pr3.getInputStream()));
					 line=null;
					 while((line=input.readLine()) != null) {
		                    System.out.println(line); 
					 }
					 exitVal = pr3.waitFor();
					 System.out.println("Exited with error code "+exitVal); 
					 
					 
					
					
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
		}
		
	}


