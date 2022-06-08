package entidades;

import java.util.ArrayList;
import java.util.Date;

public class Supplier {
	private static Supplier instancia = new Supplier();
	private ArrayList<Localidad> listaLocalidades = new ArrayList<Localidad>();
	private ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
	private ArrayList<Responsable> listaResponsables = new ArrayList<Responsable>();
	private ArrayList<Factura> listaFacturas = new ArrayList<Factura>();
	
	private Supplier() {}

	public static Supplier getSupplier() {
		if (instancia == null) {
			instancia = new Supplier();
		}
		return instancia;
	}

	private ArrayList<Localidad> getlocalidades() {
		if (listaLocalidades.isEmpty()){
			Pais estePais = new Pais("Este Pais");
			Pais otroPais = new Pais ("Otro Pais");

			Provincia p01 = new Provincia("Provincia1", estePais);
			Provincia p02 = new Provincia("Provincia2", estePais);
			Provincia pOtroPais = new Provincia("ProvinciaOtroPais", otroPais);

			listaLocalidades.add(new Localidad("Localidad 1 Provincia 1", p01));
			listaLocalidades.add(new Localidad("Localidad 2 Provincia 1", p01));
			listaLocalidades.add(new Localidad("Localidad 1 Provincia 2", p02));
			listaLocalidades.add(new Localidad("Localidad otro pais", pOtroPais));
		}

		return listaLocalidades;
	}

	private ArrayList<Bien> getListaBienes(int cant){
		ArrayList<Bien> ret = new ArrayList<Bien>();
		double precio;
		for (int i =0; i<cant ; i++) {
			precio = (Math.floor(Math.random()*20+1) *50); //Valores aleatorios entre 50 y 1000
			ret.add(new Bien("Bien "+ (i+1) + " del proveedor", precio));
		}

		return ret;
	}

	public ArrayList<Responsable> getResponsables(){
		if (listaResponsables.isEmpty()){
			ArrayList<Localidad> localidades = getlocalidades();

			listaResponsables.add(new Responsable("Responsable1", localidades.get(0),"Oficina"));
			listaResponsables.add(new Responsable("Responsable2", localidades.get(1),"Oficina"));
			listaResponsables.add(new Responsable("Responsable3", localidades.get(2),"Oficina"));

		}
		return listaResponsables;

	}
	public ArrayList<Proveedor> getProveedores(){
		if (listaProveedores.isEmpty()) {
			ArrayList<Localidad> localidades = getlocalidades();

			listaProveedores.add(new Proveedor("Pepe", localidades.get(0),getListaBienes(25)));//Proveedor de la misma loc que el responsable
			listaProveedores.add(new Proveedor("Chino", localidades.get(1),getListaBienes(10)));//Misma provincia distinta loc
			listaProveedores.add(new Proveedor("Juan", localidades.get(2),getListaBienes(2)));//Distinta provincia
			listaProveedores.add(new Proveedor("Carlos", localidades.get(0),getListaBienes(3)));//Proveedor de la misma loc que el responsable
			listaProveedores.add(new Proveedor("Extranjero", localidades.get(3),getListaBienes(15)));//Distinto pais		
		}

		return listaProveedores;

	}

	public ArrayList<Factura> getFacturas(){
		if (listaFacturas.isEmpty()) {
		ArrayList<Responsable> responsables= getResponsables();
		ArrayList<Proveedor> proveedores= getProveedores();
		Responsable responsable = responsables.get(0);
		Date fecha1 = new Date();
		Date fecha2 = new Date();
		Date fecha3 = new Date();
		Date fecha4 = new Date();
		fecha1.setDate(10);
		listaFacturas.add(new Factura(new ArrayList<Bien>(proveedores.get(0).bienes().subList(0, 3)),proveedores.get(0),responsables.get(0),fecha1));
		fecha2.setDate(12);
		listaFacturas.add(new Factura(new ArrayList<Bien>(proveedores.get(1).bienes().subList(2, 7)),proveedores.get(1),responsables.get(0),fecha2));
		fecha3.setDate(15);
		listaFacturas.add(new Factura(new ArrayList<Bien>(proveedores.get(2).bienes()),proveedores.get(2),responsables.get(0),fecha3));
		fecha4.setDate(20);
		listaFacturas.add(new Factura(new ArrayList<Bien>(proveedores.get(0).bienes().subList(0, 1)),proveedores.get(0),responsables.get(1),fecha4));
		}
		return listaFacturas;
	}

	public ArrayList<Bien> listarBienes(ArrayList<Proveedor> proveedores){
		ArrayList<Bien> ret = new ArrayList<Bien>();
		proveedores.stream()
		.map(proveedor -> proveedor.bienes())
		.flatMap(bienes -> bienes.stream())
		.forEach(bien -> ret.add(bien));	
		return ret;
	}


}
