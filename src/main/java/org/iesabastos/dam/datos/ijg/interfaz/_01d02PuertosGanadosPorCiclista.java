package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Equipo;
import org.iesabastos.dam.datos.ijg.Puerto;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.Scanner;

public class _01d02PuertosGanadosPorCiclista {
	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		//scanner
		short dorsal;
		dorsal = scanner.nextShort();
		Ciclista ciclista = (Ciclista) session.get(Ciclista.class, dorsal);

		for (Puerto p : ciclista.getPuertos()
		) {
			System.out.println(p);
		}
		session.close();
	}
}
