package entidades;

public class Responsable extends Persona{
	////Atributos
	private static int idCount;
	private String oficina;
	
	
	////G&S
	public static int idCount() {
		return idCount;
	}
	public String oficina() {
		return oficina;
	}
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	
	////Constructores
	public Responsable (String nombre, Localidad localidad, String oficina) {
		super (++idCount, nombre, localidad); //Mejorable con un metodo que devuelva el id y que lo incremente solo al crearse la instancia
		this.oficina = oficina;
		
	}
	
	////Metodos

}
