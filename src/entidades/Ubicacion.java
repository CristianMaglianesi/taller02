package entidades;

public class Ubicacion {
	////Atributos
	private	int id;
	private String nombre;
	
	////G&S
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Constructores
	public Ubicacion(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	
}
