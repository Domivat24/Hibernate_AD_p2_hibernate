package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.iesabastos.dam.datos.ijg.Equipo;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.Scanner;

public class _02bModificarEquipo {
	public static void main(String[] args) {
		String equipoS, director;
		Scanner scanner = new Scanner(System.in);
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		System.out.println("Nombre del equipo:");
		equipoS = scanner.nextLine();
		System.out.println("Nuevo director del equipo:");
		director = scanner.nextLine();

		try {
			Equipo equipo = (Equipo) session.get(Equipo.class, equipoS);
			equipo.setDirector(director);
			session.save(equipo);
			session.getTransaction().commit();
		} catch (NullPointerException e) {
			System.out.println("Equipo no existe en la BBDD");
		}
		session.close();
	}
}

