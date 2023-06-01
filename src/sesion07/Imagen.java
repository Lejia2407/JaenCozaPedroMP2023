package sesion07;

import java.util.ArrayList;

public class Imagen {
	private String formatoImagen;
	private String tipoImagen;
	private int lineas;
	private int columnas;
	private ArrayList<Banda> bandas;

	public Imagen(int lineas, int columnas, String formatoImagen, String tipoImagen) {
		this.lineas = lineas;
		this.columnas = columnas;
		this.formatoImagen = formatoImagen;
		this.tipoImagen = tipoImagen;
		this.bandas = new ArrayList<Banda>();
	}

	public Number[] getDatosPixel(int x, int y) throws XYFueraImagenException {
		if (!XYValida(x, y, x, y))
			throw new XYFueraImagenException("XY no valida");
		
		Number[] datos = new Number[getNumeroBandas()];
		
		for (int i = 0; i < getNumeroBandas(); i++)
			datos[i] = getBanda(i).getDatoXY(x, y);
		return datos;
	}

	public Imagen extraerImagen(int x1, int y1, int x2, int y2) throws XYFueraImagenException {
		XYValida(x1, y1, x2, y2);
		int lineas = y2 - y1 + 1;
		int columnas = x2 - x1 + 1;
		Imagen img = new Imagen(lineas, columnas, formatoImagen, tipoImagen);
		for (int i = 0; i < bandas.size(); i++) {
			Number[][] datos = new Number[lineas][columnas];
			for (int k = x1, f = 0; k < (x2 + 1); k++, f++) {
				for (int j = y1, c = 0; j < (y2 + 1); j++, c++) {
					datos[f][c] = getBanda(i).getDatoXY(k, j);
				}
			}
			Banda bandaIntegers = new Banda<>(getBanda(i).getNombreBanda(), datos);
			img.anadirBanda(bandaIntegers);
		}
		return img;
	}

	public void anadirBanda(Banda<?> banda) {
		bandas.add(banda);
	}

	public void eliminarBanda(int i) {
		bandas.remove(i);
	}

	public Banda<Number> getBanda(int i) {
		return (Banda<Number>) bandas.get(i);
	}

	public ArrayList<Banda<?>> getBandas() {
		return (ArrayList<Banda<?>>) bandas.clone();
	}

	public int getNumeroBandas() {
		return bandas.size();
	}

	public int getLineas() {
		return lineas;
	}

	public int getColumnas() {
		return columnas;
	}

	public String getTipoImagen() {
		return tipoImagen;
	}

	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}

	public String getFormatoImagen() {
		return formatoImagen;
	}

	public void setFormatoImagen(String formatoImagen) {
		this.formatoImagen = formatoImagen;
	}

	public void setBandas(ArrayList<Banda> bandas) {
		this.bandas = bandas;
	}

	private boolean XYValida(int x1, int y1, int x2, int y2) throws XYFueraImagenException {
		if ((x1 > lineas || x2 > lineas) || (y1 > columnas || y2 > columnas))
			throw new XYFueraImagenException(null);
		return true;
	}

	public String toString() {
		return null;
	}
}