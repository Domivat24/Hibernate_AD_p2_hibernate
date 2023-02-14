package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.List;

public class _06HQLVariasTablas {
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		infoEtapaCiclista(session);
		System.out.println();
		infoEquipo(session);

	}

	public static void infoEtapaCiclista(Session session) {
		Query query = session.createQuery("select e.salida, e.llegada, c.nombre from Etapa as e inner join e.ganador as c");
		List<Object[]> etapas = query.list();
		for (Object[] e : etapas
		) {
			System.out.printf("Ganador de la etapa con ciudad de salida %s y ciudad de llegada %s es: ¡%s!\n", e[0], e[1], e[2]);
		}
	}

	public static void infoEquipo(Session session) {
		//Ciclistas nacidos entre el 1/1/1979 y 31/12/1980.
		Query query = session.createQuery("select e.nomeq, e.director, count(c.dorsal) from Equipo as e inner join e.ciclistas as c group by e.nomeq");
		List<Object[]> equipos = query.list();
		for (Object[] e : equipos
		) {
			System.out.printf("Equipo %s cuyo director es %s, lo forman %d ciclistas\n", e[0], e[1], e[2]);
		}
	}
}
