package sesion06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class ConjuntoDatos {
	private File textFile;
	private String espacioSeparador;
	private Locale region;
	private List cabecera;
	private int numeroLineas;
	private int numeroColumnas;
	private double[][] datos;


	//@param textFile     		archivo de texto como parametro tipo file
	//@param espacioSeparador   lo que separa un elemento de otro
	//@throws IOException 		excepcion que sale si no encuentra el archivo
	 //@param locale      		obj de la region que se hace pasar por parametro
	
	public ConjuntoDatos(File textFile, String espacioSeparador, Locale region) throws IOException {
		super();
		this.textFile = textFile;
		this.espacioSeparador = new String(espacioSeparador);
		this.region = region;
		this.numeroLineas = numLineas(textFile);
		this.numeroColumnas = numColumnas(textFile);
		this.cabecera = cabecera(textFile);
		this.datos = leerDatos(textFile, numeroLineas, numeroColumnas);
	}


	private List cabecera(File archivoTexto) throws IOException 
	{
		FileReader fr = new FileReader(archivoTexto);
		BufferedReader br = new BufferedReader(fr);
		String str;
		
		str = br.readLine();
		
		ArrayList cabecera = new ArrayList();
		Scanner scanner = new Scanner(str);
		
		scanner.useDelimiter(espacioSeparador);
		scanner.useLocale(region);
		
		while (scanner.hasNext())
			cabecera.add(scanner.next());
		
		br.close();
		
		return cabecera;
	}

	private int numLineas(File archivoTexto) throws IOException 
	{
		FileReader fr = new FileReader(archivoTexto);
		BufferedReader br = new BufferedReader(fr);
		
		int numLineas = 0;
		br.readLine();
		
		while (br.readLine() != null)
			numLineas++;
		
		br.close();
		
		return numLineas;
	}

	private int numColumnas(File textFile) throws IOException 
	{
		FileReader fr = new FileReader(textFile);
		BufferedReader br = new BufferedReader(fr);
		
		String str;
		str = br.readLine();
		
		int numColumnas = 0;
		
		Scanner scanner = new Scanner(str);
		
		scanner.useDelimiter(this.espacioSeparador);
		scanner.useLocale(region);
		
		while (scanner.hasNext()) 
		{
			scanner.next();
			numColumnas++;
		}
		
		br.close();
		
		return numColumnas;
	}

	private double[][] leerDatos(File textFile, int filas, int columnas) 
	{
		
		double[][] matrizDatos = new double[filas][columnas];
		try 
		{
			FileReader fr = new FileReader(textFile);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			
			for (int i = 0; i < filas; i++) 
			{
				String str;
				Scanner sc = new Scanner(br.readLine());
				sc.useDelimiter(this.espacioSeparador);
				sc.useLocale(this.region);
				
				int j = 0;
				
				while (sc.hasNext()) 
				{
					matrizDatos[i][j] = sc.nextDouble();
					j++;
				}
			}
			
			br.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return matrizDatos;
	}


	public double[] getColumna(int columna) 
	{
		if (columna < 0 || columna > numeroColumnas)
			throw new RuntimeException("Columna no valida");
		
		double[] array = new double[numeroLineas];
		
		for (int i = 0; i < numeroLineas; i++)
			array[i] = datos[i][columna];
		
		return array;
	}

	public double[] getColumna(String columna) 
	{
		Iterator iterador = cabecera.iterator();
		boolean encontrado = false;
		
		int i = 0;
		int indice = 0;
		
		while (iterador.hasNext()) 
		{
			String str = (String) iterador.next();
			
			if (str.contentEquals(columna)) 
			{
				indice = i;
				encontrado = true;
				break;
			}
			
			i++;
		}
		
		if (!encontrado)
			throw new RuntimeException("Columna no valida");
		
		return getColumna(indice);
	}

	public File getArchivoTexto() {
		return textFile;
	}

	public String getSeparador() {
		return espacioSeparador;
	}

	public Locale getLocale() {
		return region;
	}

	public List getCabecera() {
		return cabecera;
	}

	public int getNumeroLineas() {
		return numeroLineas;
	}

	public int getNumeroColumnas() {
		return numeroColumnas;
	}

	public double[][] getDatos() {
		return datos;
	}


	public void exportar(String[] cabecera, String textFile, String separador) throws IOException 
	{
		double[][] tempDatos = new double[numeroLineas][cabecera.length];
		
		for (int i = 0; i < cabecera.length; i++) 
		{
			double[] tempCol = getColumna(cabecera[i]);
			
			for (int j = 0; j < tempCol.length; j++) 
			{
				tempDatos[j][i] = tempCol[j];
			}
		}
		
		PrintWriter pw = new PrintWriter(textFile);
		for (int i = 0; i < cabecera.length; i++) 
		{
			pw.print(cabecera[i]);
			if (i < cabecera.length - 1)
				pw.print(separador);
		}
		
		pw.println();
		for (int i = 0; i < tempDatos.length; i++) 
		{
			
			for (int j = 0; j < tempDatos[0].length; j++) 
			{
				pw.print(tempDatos[i][j]);
				
				if (j < tempDatos[0].length - 1)
					pw.print(separador);
			}
			
			pw.println();
		}
		
		pw.close();
	}

	public ConjuntoDatos conjuntoDatos(String[] cabecera, String textFile, String separador, Locale locale)
			throws Exception 
	{
		exportar(cabecera, textFile, separador);
		
		return new ConjuntoDatos(new File(textFile), separador, locale);
	}
}