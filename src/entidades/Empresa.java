package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
	private ArrayList<Responsable> responsables;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Bien> bienes;
	private ArrayList<Factura> facturas;
	
	////Metodos
	// Se debe poder listar todas las facturas de un proveedor especificado.
	ArrayList<Factura> listarFacturaByProveedor(Proveedor p){
		ArrayList<Factura> ret= (ArrayList<Factura>) facturas.stream()
				.filter(f -> f.proveedor().equals(p))
				.collect(Collectors.toList());
		return ret;

	}
	
	//Se debe poder listar todas las facturas de un responsable especificado.
	ArrayList<Factura> listarFacturaByResponsable(Responsable r) {
		ArrayList<Factura> ret= (ArrayList<Factura>) facturas.stream()
				.filter(f -> f.responsable().equals(r))
				.collect(Collectors.toList());
		return ret;
	}	
	
	//Se debe poder listar todos los nombres de los proveedores por una determinada Localidad, ordenado de forma ascendente por nombre.
	//Utilizar el stream filter, sorted, map y collect. Filter con el método esDeLocalidad(…), sorted ordenado ascendente por nombre, 
	//map tomando el nombre de cada uno de los proveedores.
	ArrayList<String> listarNombresProveedores(Localidad l){
		ArrayList<String> ret= (ArrayList <String>)proveedores.stream()
				.filter(p -> p.esDeLocalidad(l))
				.sorted ((p1,p2) -> p1.nombre().compareToIgnoreCase(p2.nombre()))
				.map (p -> p.nombre())
				.collect(Collectors.toList());
		return ret;
	}
	
	//Se debe poder listar todos los bienes solicitados por los responsables que residen en una Localidad especificada.
	ArrayList<Bien> listarBienesByLocalidad(Localidad l){
		ArrayList<Bien> ret = (ArrayList<Bien>) facturas.stream()
				.filter(f -> f.responsable().esDeLocalidad(l))
				.map(Factura::bienes)
				.flatMap(List::stream)
				.distinct()
				.collect(Collectors.toList());
		return ret;
	}
	
	//MetodosSe debe poder listar todos los bienes con un precio mayor a un valor pasado por parámetros.
	ArrayList<Bien> listarBienesByPrecioMayor(Double precioMayor){
		ArrayList<Bien> ret = (ArrayList<Bien>) bienes.stream()
				.filter(b -> b.precio() > precioMayor)
				.collect(Collectors.toList());
		return ret;
	}
	
	// Se debe poder listar todas las facturas con un monto total mayor a un valor pasado por parámetros.
	ArrayList<Factura> listarFacturasByMontoMayor(Double montoMayor){
		ArrayList<Factura> ret = (ArrayList<Factura>) facturas.stream()
				.filter(f -> f.montoTotal() > montoMayor)
				.collect(Collectors.toList());
		return ret;
	}
	
	//Se debe poder listar cadenas de String que debe componer de la siguiente manera: “En la fecha <Fecha>, <NombreProveedor>
	//facturó con un total de $<montoTotal> con <bienes.size()>”. Es decir, se debe poder listar todas las facturas realizadas 
	//por un proveedor p, ordenado por fecha de forma Descendente(de nuevo a antiguo) en formato DIA/MES/AÑO, implementar la 
	//clase Comparable y ordenarlas con Collection.sort.
	ArrayList<String> listarFacturadasPorProveedor(Proveedor p){
		ArrayList<Factura> facturasDelProveedor = listarFacturaByProveedor(p);//Facturas de un proveedor
		Collections.sort(facturasDelProveedor); //Las ordeno por fecha 
		ArrayList <Date> fechas = (ArrayList<Date>) facturasDelProveedor.stream() //Hago una lista de las fechas 
				.map(Factura::fecha)
				.distinct()
				.collect(Collectors.toList());
		for (Date fecha:fechas) {
			long cont = facturasDelProveedor.stream()
							.filter(factura -> factura.fecha().equals(fecha))
							.map(Factura::bienes)
							.flatMap(List::stream)
							.count();
			double monto = facturasDelProveedor.stream()
					.filter(factura ->factura.fecha().equals(fecha))
					.map(Factura::montoTotal)
					.reduce(0.0, Double::sum);
			
			System.out.println("En la fecha "+fecha+", "+p.nombre()+" facturo con un total de $"+monto+" con "+cont+" bienes.");
					
		}

		
													 
		
		return null;
	}

}
