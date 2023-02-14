package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.List;

public class _05HQLBasicas {
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		nacidos1980(session);
		totalCiclistas(session);
		totalCiclistasBanesto(session);

	}

	public static void nacidos1980(Session session) {
		//Ciclistas nacidos entre el 1/1/1979 y 31/12/1980.
		Query query = session.createQuery("from Ciclista c WHERE c.nacimiento >= '1979-1-1' AND c.nacimiento <= '1980/12/31'");
		List<Ciclista> ciclistas = (List<Ciclista>) query.list();
		for (Ciclista c : ciclistas
		) {
			System.out.println(c);
		}

	}

	public static void totalCiclistas(Session session) {

		Query query = session.createQuery("select count(*) from Ciclista");
		Long total = (Long) query.uniqueResult();
		System.out.println("Total de ciclistas: " + total);
	}

	public static void totalCiclistasBanesto(Session session) {
		Query query = session.createQuery("from Ciclista c WHERE c.equipo = 'Banesto'");
		List<Ciclista> ciclistas = (List<Ciclista>) query.list();
		System.out.println("Total de ciclistas del equipo Banesto: " + ciclistas.size());
	}
}
