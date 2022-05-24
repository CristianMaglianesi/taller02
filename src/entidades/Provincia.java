package entidades;

public class Provincia extends Ubicacion{

	////Atributos
	private static int idCount=0;
	private Pais pais;
	
	////G&S
	public static int idCount() {
		return idCount;
	}

	public Pais pais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	////Constructores
	public Provincia(int id, String nombre, Pais pais) {
		super(++idCount, nombre);
		this.pais=pais;
	}
	
	////Metodos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provincia otro = (Provincia) o;
        return (this.getId() == otro.getId() &&
        		this.pais().equals(otro.pais())); //Necesario comprobar? si cada provincia tiene un ID unico
    }

}
