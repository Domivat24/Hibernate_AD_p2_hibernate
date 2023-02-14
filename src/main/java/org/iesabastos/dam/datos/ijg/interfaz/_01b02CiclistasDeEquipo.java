package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Equipo;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.Scanner;

public class _01b02CiclistasDeEquipo {
	public static void main(String[] args) {
		{
			Scanner scanner = new Scanner(System.in);
			HibernateUtil.buildSessionFactory();
			HibernateUtil.openSession();

			Session session = HibernateUtil.getCurrentSession();
			session.beginTransaction();
			String equipo;
			equipo = scanner.nextLine();
			Equipo equipo1 = (Equipo) session.get(Equipo.class, equipo);
			for (Ciclista c: equipo1.getCiclistas()) {
				System.out.println(c);
			}
			session.close();
		}
	}
}
