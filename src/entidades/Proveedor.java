package entidades;

import java.util.ArrayList;

public class Proveedor extends Persona{
	////Atributos
	private static	int	idCount = 0;
	private ArrayList <Bien> bienes;
	
	
	////G&S
	public static int idCount() {
		return idCount;
	}
	public ArrayList<Bien> bienes() {
		return bienes;
	}
	public void setBienes(ArrayList<Bien> bienes) {
		this.bienes = bienes;
	}
	
	
	////Constructores
	public Proveedor (String nombre, Localidad localidad) {
		super (++idCount, nombre, localidad);
		bienes = new ArrayList<Bien>();
	}
	
	////Metodos

}
