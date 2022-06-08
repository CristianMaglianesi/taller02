package entidades;

import Interfaces.criterioBusqueda;

public abstract class Persona implements criterioBusqueda<Localidad>{
	////Atributos
	private int id;
	private String nombre;
	private Localidad localidad;
	
	////G&S
	public int id() {
		return id;
	}

	public String nombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Localidad localidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	////Constructores
	public Persona(int id, String nombre, Localidad localidad) {
		this.id = id;
		this.nombre = nombre;
		this.localidad = localidad;
	}
	
	////Metodos
	@Override
	public Boolean esDeLocalidad(Localidad unaLocalidad) {
		return this.localidad.equals(unaLocalidad);
	}

}
