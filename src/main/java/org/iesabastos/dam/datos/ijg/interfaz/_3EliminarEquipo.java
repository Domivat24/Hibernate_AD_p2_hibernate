package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Equipo;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.Scanner;

public class _3EliminarEquipo {
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		Equipo equipo = (Equipo) session.get(Equipo.class, "Los manolos");
		for (Ciclista c : equipo.getCiclistas()
		) {
			session.delete(c);
		}
		session.delete(equipo);
		session.getTransaction().commit();
		session.close();

	}
}
