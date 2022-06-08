package entidades;

import java.util.ArrayList;
import java.util.Date;

public class Factura implements Comparable<Factura>{
	
	private static final int MAX_BIENES = 20;
	////Atributos
	private static	int	idCount;
	private int id;
	private double montoTotal;
	private ArrayList <Bien> bienes;
	private Responsable responsable;
	private Proveedor proveedor;
	private Date fecha;
	
	////G&S
	public static int idCount() {
		return idCount;
	}
	
	public static int max() {
		return MAX_BIENES;
	}
	public int id() {
		return id;
	}

	public double montoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public ArrayList<Bien> bienes() {
		return bienes;
	}
	public void setBienes(ArrayList<Bien> bienes) {
		this.bienes = bienes;
	}
	public Responsable responsable() {
		return responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	public Proveedor proveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Date fecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	////Constructores
	public Factura(ArrayList<Bien> bienes, Proveedor proveedor, Responsable responsable,
			Date fecha) {
		this.id = ++idCount;
		this.bienes = bienes;
		this.responsable = responsable;
		this.proveedor = proveedor;
		montoTotal = calcularMonto();
		this.fecha = fecha;
	}
	
	////Metodos
	
	private double factorPorUbicacion(){
		double ret;
		if (responsable.esDeLocalidad(proveedor.localidad())) {
			ret = 1.1;
		}
		else if(responsable.localidad().provincia().equals(proveedor.localidad().provincia())) {
			ret = 1.3;
		}
		else {
			ret = 1.7;
		}
		return ret;
	}
	
	private double descuentoPorCant() {
		double ret;
		if (bienes.size() > 10) {
			ret  = 0.2;
		}
		else if (bienes.size()> 5) {
			ret =  0.1;
		}
		else {
			ret =  0;
		}
		return ret;
	}
	
	private double calcularMonto() {
		double montoTotal = 0;
		for (Bien unBien : bienes) {
			montoTotal += unBien.precio();
		}
		return montoTotal* this.factorPorUbicacion()*(1-descuentoPorCant());
	}
	@Override
	public int compareTo(Factura o) {
		if (this.fecha().after(o.fecha())) return 1;
		if (this.fecha().before(o.fecha())) return -1;
		return 0;
	}
}
