package excepciones;

public class limiteDeBienesSuperados extends Exception {

	public limiteDeBienesSuperados(int max){
		super ("Una factura no puede tener mas de "+max+" bienes" );
	}
}
