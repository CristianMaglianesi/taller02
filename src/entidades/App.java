package entidades;

import java.util.ArrayList;
import java.util.Date;

import excepciones.limiteDeBienesSuperados;
import excepciones.proveedorDeDistintoPaisException;

public class App {
	
	public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		
		Supplier supplier = Supplier.getSupplier();
		ArrayList<Responsable> responsables = supplier.getResponsables();
		ArrayList<Proveedor>proveedores = supplier.getProveedores();
		ArrayList<Factura>facturas = supplier.getFacturas();
		ArrayList<Bien>bienes = supplier.listarBienes(proveedores);
		

		/*ArrayList<Factura> listaFacturasByResponsable = empresa.listarFacturaByResponsable(responsables.get(0));
		System.out.println(listaFacturasByResponsable);
		
		ArrayList<Factura> listaFacturasByProveedor = empresa.listarFacturaByProveedor(proveedores.get(0));
		System.out.println(listaFacturasByProveedor);
		
		ArrayList<String> listaNombreProveedores= empresa.listarNombresProveedores(proveedores.get(0).localidad());
		System.out.println(listaNombreProveedores);
		ArrayList <Bien> listaBienesByLocalidad = empresa.listarBienesByLocalidad(responsables.get(1).localidad()); 
		System.out.println(listaBienesByLocalidad.size());
		
		ArrayList <Bien> listaBienesByPrecioMayor = empresa.listarBienesByPrecioMayor(950.0);
		System.out.println(listaBienesByPrecioMayor);
		
		ArrayList<Factura> listaFacturasByMontoMayor = empresa.listarFacturasByMontoMayor(200.0);
		System.out.println(listaFacturasByMontoMayor);
		
		ArrayList<String> listaFacturadasPorProveedor = empresa.listarFacturadasPorProveedor(proveedores.get(0));
		System.out.println(listaFacturadasPorProveedor)*/
		
		
		//Para probar excepcion por distinto pais, cambiar el segundo argumento por proveedores.get(0/1/2/3) para que funcione, proveedores.get(4) para lanzar excepcion
		//Para probar excepcion por maximo de bienes superado, cambiar el .subList del primer argumento por cualquiera que de una lista de mas de 20 elementos
		/*try {
			empresa.crearFactura(new ArrayList<Bien>(proveedores.get(0).bienes().subList(0, 5)),proveedores.get(1),responsables.get(0),new Date(10));
		} catch (proveedorDeDistintoPaisException e) {
			e.printStackTrace();
		} catch (limiteDeBienesSuperados e) {
			e.printStackTrace();
		}*/
	}
}



