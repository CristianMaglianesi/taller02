package entidades;

public class Pais extends Ubicacion{

	////Atributos
	private static	int	idCount = 0;
	
	////Constructores
	public Pais(String nombre) {
		super((++idCount), nombre);
	}
	
	////Metodos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais otro = (Pais) o;
        return (this.getId() == otro.getId());
    }
}
