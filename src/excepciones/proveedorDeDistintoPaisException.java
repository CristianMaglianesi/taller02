package excepciones;

public class proveedorDeDistintoPaisException extends Exception {
	public proveedorDeDistintoPaisException() {
		super("El proveedor y el responsable son de distintos paises");
	}
}
