package com.bpingar.arias;

import java.io.Serializable;
import java.util.Date;

public class Compra implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String nombreProducto;
	Float numeroUnidades;
	Date fechaCompra;

	public Compra(String nombreProducto, Float numeroUnidades,
			Date fechaCompra) {
		this.nombreProducto = nombreProducto;
		this.numeroUnidades = numeroUnidades;
		this.fechaCompra = fechaCompra;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String numeroUnidades) {
		this.nombreProducto = numeroUnidades;
	}

	public Float getNumeroUnidades() {
		return numeroUnidades;
	}

	public void setNumeroUnidades(Float numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
}
