package org.iesabastos.dam.datos.ijg;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ciclista")
public class Ciclista implements Serializable {
	@Id
	@GeneratedValue
	private short dorsal;
	private Date nacimiento;
	private String nombre;
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "nomeq")
	private Equipo equipo;

	@OneToMany(mappedBy = "ganador", cascade = CascadeType.DETACH)
	List<Etapa> etapasGanadas;
	@OneToMany(mappedBy = "ganador", cascade = CascadeType.DETACH)
	List<Puerto> puertos;

	public List<Puerto> getPuertos() {
		return puertos;
	}

	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}

	public List<Etapa> getEtapasGanadas() {
		return etapasGanadas;
	}

	public void setEtapasGanadas(List<Etapa> etapasGanadas) {
		this.etapasGanadas = etapasGanadas;
	}

	public Ciclista() {
	}

	public short getDorsal() {
		return dorsal;
	}

	public void setDorsal(short dorsal) {
		this.dorsal = dorsal;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Ciclista{" +
				"dorsal=" + dorsal +
				", nacimiento=" + nacimiento +
				", nombre='" + nombre + '\'' +
				", equipo=" + equipo +
				'}';
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
}