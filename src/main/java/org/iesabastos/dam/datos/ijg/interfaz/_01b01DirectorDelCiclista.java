package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Equipo;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class _01b01DirectorDelCiclista {
	public static void main(String[] args) {
		{
			Scanner scanner = new Scanner(System.in);
			HibernateUtil.buildSessionFactory();
			HibernateUtil.openSession();

			Session session = HibernateUtil.getCurrentSession();
			session.beginTransaction();
			short id;
			id = scanner.nextShort();
			Ciclista ciclista = (Ciclista) session.get(Ciclista.class, id);
			System.out.println((ciclista.getEquipo().getDirector()));
			session.close();
		}
	}
}
