package org.iesabastos.dam.datos.ijg;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "etapa")
public class Etapa implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short netapa;
	private short km;

	public short getNetapa() {
		return netapa;
	}

	public void setNetapa(short netapa) {
		this.netapa = netapa;
	}

	public short getKm() {
		return km;
	}

	public void setKm(short km) {
		this.km = km;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getLlegada() {
		return llegada;
	}

	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}

	public Ciclista getGanador() {
		return ganador;
	}

	public void setGanador(Ciclista ganador) {
		this.ganador = ganador;
	}

	public Etapa() {
	}

	private String salida;
	private String llegada;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dorsal")
	private Ciclista ganador;
	@OneToMany(mappedBy = "etapa")
	List<Puerto> puertos;

	public List<Puerto> getPuertos() {
		return puertos;
	}

	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}

	@Override
	public String toString() {
		return "Etapa{" +
				"netapa=" + netapa +
				", km=" + km +
				", salida='" + salida + '\'' +
				", llegada='" + llegada + '\'' +
				", ganador=" + ganador +
				'}';
	}
}
