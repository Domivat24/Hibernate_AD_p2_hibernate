package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Equipo;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class _04EliminarEquipoYCambiarCiclistas {
	public static void main(String[] args) {
		String nombre, fecha, equipoS;
		short dorsal;
		Scanner scanner = new Scanner(System.in);
		Scanner scannerNum = new Scanner(System.in);
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();


		System.out.println("Nombre del equipo que desea eliminar:");
		nombre = scanner.nextLine();
		System.out.println("Nombre del equipo al que desea trasladar los jugadores de " + nombre);
		equipoS = scanner.nextLine();


		try {
			Equipo equipo = (Equipo) session.get(Equipo.class, nombre);
			Equipo equipo2 = (Equipo) session.get(Equipo.class, equipoS);
			for (Ciclista c : equipo.getCiclistas()
			) {
				c.setEquipo(equipo2);
				session.save(c);

			}
			session.delete(equipo);
			session.getTransaction().commit();
		} catch (NullPointerException e) {
			System.out.println("Alguno de los equipos no existe en la BBDD");
		}
		session.close();
	}
}
