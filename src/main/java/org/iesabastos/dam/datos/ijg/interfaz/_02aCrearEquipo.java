package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Equipo;
import org.iesabastos.dam.datos.ijg.Puerto;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.Scanner;

public class _02aCrearEquipo {
	public static void main(String[] args) {
		String equipoS, director;
		Scanner scanner = new Scanner(System.in);
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		System.out.println("Nombre del equipo:");
		equipoS = scanner.nextLine();
		System.out.println("Director del equipo:");
		director = scanner.nextLine();
		Equipo equipo = new Equipo();
		equipo.setNomeq(equipoS);
		equipo.setDirector(director);
		try {
			session.save(equipo);
			session.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			System.out.println("Entrada duplicada:\n" + equipoS + " ya existe en la BBDD");
		}


		session.close();


	}
}
