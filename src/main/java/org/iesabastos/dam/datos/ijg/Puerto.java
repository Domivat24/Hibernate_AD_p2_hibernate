package org.iesabastos.dam.datos.ijg;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "puerto")
public class Puerto implements Serializable {
	@Id
	private String nompuerto;
	private short altura;
	private String categoria;
	private double pendiente;
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "dorsal")
	private Ciclista ganador;

	@Override
	public String toString() {
		return "Puerto{" +
				"nompuerto='" + nompuerto + '\'' +
				", altura=" + altura +
				", categoria='" + categoria + '\'' +
				'}';
	}

	public String getNompuerto() {
		return nompuerto;
	}

	public void setNompuerto(String nompuerto) {
		this.nompuerto = nompuerto;
	}

	public short getAltura() {
		return altura;
	}

	public void setAltura(short altura) {
		this.altura = altura;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPendiente() {
		return pendiente;
	}

	public void setPendiente(double pendiente) {
		this.pendiente = pendiente;
	}

	public Ciclista getGanador() {
		return ganador;
	}

	public void setGanador(Ciclista ganador) {
		this.ganador = ganador;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public Puerto() {
	}

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "netapa")
	private Etapa etapa;

}
