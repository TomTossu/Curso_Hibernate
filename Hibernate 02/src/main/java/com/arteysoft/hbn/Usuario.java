package com.arteysoft.hbn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@Column(name="id")
	private String id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	
	
	
	public Usuario() {
	}

	public Usuario(String id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}