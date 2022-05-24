package entidades;

public class Localidad extends Ubicacion{
	////Atributos
	private static int idCount;
	private Provincia provincia;
	
	////G&S
	public static int idCount() {
		return idCount;
	}

	public Provincia provincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	////Constructores
	public Localidad(String nombre, Provincia provincia) {
		super(++idCount, nombre);
		this.provincia = provincia;
	}
	
	////Metodos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidad otro = (Localidad) o;
        return (this.getId() == otro.getId()) &&
        		this.provincia().equals(otro.provincia()); //Necesario? si localidad tiene ID unico
    }
}
