package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Etapa;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.Scanner;

public class _01c02EtapasGanadasPorCiclista {
	public static void main(String[] args) {
		{
			Scanner scanner = new Scanner(System.in);
			HibernateUtil.buildSessionFactory();
			HibernateUtil.openSession();

			Session session = HibernateUtil.getCurrentSession();
			session.beginTransaction();
			//scanner
			short id;
			id = scanner.nextShort();
			Ciclista ciclista = (Ciclista) session.get(Ciclista.class, id);
			for (Etapa etapa : ciclista.getEtapasGanadas()
			) {
				System.out.printf("Salida %s y llegada %s\n", etapa.getSalida(), etapa.getLlegada());

			}
			session.close();

		}
	}
}
