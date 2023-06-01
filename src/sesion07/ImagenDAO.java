package sesion07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ImagenDAO {

	public static void escribirArchivo(String nombreArchivo, Imagen imagen) throws IOException 
	{
		File file = new File(nombreArchivo);
		FileWriter fw = new FileWriter(file);
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		PrintWriter pw = new PrintWriter(bw);
		String nombre = file.getName();
		
		int indice = nombre.indexOf(".");
		
		nombre = nombre.substring(0, indice);
		pw.println(nombre + ".dat");
		
		pw.println(imagen.getFormatoImagen());
		pw.println(imagen.getTipoImagen());
		
		int nBandas = imagen.getNumeroBandas();
		pw.println(nBandas);
		
		String string = "[";
		
		for (Iterator<Banda<?>> iterator = imagen.getBandas().iterator(); iterator.hasNext();) {
			Banda<?> banda = iterator.next();
			string = string + banda.getNombreBanda() + ";";
		}
		
		string = string.substring(0, string.length() - 1);
		string = string + "]";
		pw.println(string);
		
		pw.println(imagen.getLineas());
		pw.println(imagen.getColumnas());
		
		pw.close();
		
		String nombreNuevo = file.getParent();
		nombreNuevo = nombreNuevo + File.separator + nombre + ".dat";
		
		if (imagen.getFormatoImagen().equals("BSQ")) {
			escribirBSQ(nombreNuevo, imagen);
		}
	}

	private static void escribirBSQ(String nombreArchivo, Imagen imagen) throws IOException {
		Banda<Number> b = null;
		String tipoImagen = imagen.getTipoImagen();
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(nombreArchivo)));
			for (int i = 0; i < imagen.getNumeroBandas(); i++) {
				b = imagen.getBanda(i);
				for (int j = 0; j < imagen.getLineas(); j++) {
					for (int k = 0; k < imagen.getColumnas(); k++) {
						if (tipoImagen.equals("Integer"))
							dos.writeInt((Integer) b.getDatoXY(j, k));
						else
							dos.writeDouble((Double) b.getDatoXY(j, k));
					}
				}
			}
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Imagen leerArchivo(String nombreArchivo) throws IOException {
		Imagen i = null;
		String archivoImagen = "";
		String tipoImagen = "";
		int lineas = 0;
		int columnas = 0;
		String[] nombreBandasArr = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(nombreArchivo)));
			archivoImagen = br.readLine();
			tipoImagen = br.readLine();
			
			String formatoImagen = br.readLine();
			int numBandas = Integer.parseInt(br.readLine());
			
			String nombreBandas = br.readLine();
			
			nombreBandas = nombreBandas.substring(1, nombreBandas.length() - 1);
			nombreBandasArr = nombreBandas.split(";");
			
			lineas = Integer.parseInt(br.readLine());
			columnas = Integer.parseInt(br.readLine());
			
			i = new Imagen(lineas, columnas, formatoImagen, tipoImagen);
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (i == null)
			return null;
		archivoImagen = System.getProperty("user.dir") + File.separator + "src" + File.separator + 
				"sesion07" + File.separator + archivoImagen;
		i = leerBSQ(archivoImagen, i, nombreBandasArr, tipoImagen);
		return i;
	}


	private static Imagen leerBSQ(String nombreArchivo, Imagen imagen, String[] nBandas, String tipoImagen)
			throws IOException {
		
		Integer[][] datosI = null;
		Double[][] datosD = null;
		boolean isInteger = false;
		
		if (tipoImagen.equals("Integer")) {
			datosI = new Integer[imagen.getLineas()][imagen.getColumnas()];
			isInteger = true;
		} else if (tipoImagen.contentEquals("Double"))
			datosD = new Double[imagen.getLineas()][imagen.getColumnas()];
		try {
			DataInputStream dis = new DataInputStream(new

			FileInputStream(nombreArchivo));
			String nomBanda = "";
			for (int i = 0; i < nBandas.length; i++) {
				nomBanda = nBandas[i];
				for (int j = 0; j < imagen.getLineas(); j++) {
					for (int k = 0; k < imagen.getColumnas(); k++) {
						if (isInteger)
							datosI[j][k] = dis.readInt();
						else
							datosD[j][k] = dis.readDouble();
					}
				}
				Banda<Number> bandaNueva = null;
				if (isInteger)
					bandaNueva = new Banda(nomBanda, datosI);
				else
					bandaNueva = new Banda(nomBanda, datosD);
				imagen.anadirBanda(bandaNueva);
				if (tipoImagen.equals("Integer")) {
					datosI = new Integer[imagen.getLineas()][imagen.getColumnas()];
				} else if (tipoImagen.contentEquals("Double"))
					datosD = new Double[imagen.getLineas()][imagen.getColumnas()];
			}
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagen;
	}
}