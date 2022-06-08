package entidades;

public class Bien {
	//Atributos
	private static int idCount = 0;
	private int id;
	private String alias;
	private String descripcion;
	private double precio;
	private Responsable responsable;
	
	//G&S 
	public static int idCount() {
		return idCount;
	}
	
	public int id() {
		return id;
	}
	public String alias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String descripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double precio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Responsable responsable() {
		return responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	
	//Constructores

	public Bien(String alias, double precio) {
		this.id = ++idCount;
		this.alias = alias;
		this.precio = precio;
	}

}
