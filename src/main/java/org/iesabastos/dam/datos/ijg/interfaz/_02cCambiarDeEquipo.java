package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Equipo;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class _02cCambiarDeEquipo {
	public static void main(String[] args) {
		String equipoS;
		short dorsal;
		Scanner scanner = new Scanner(System.in);
		Scanner scannerNum = new Scanner(System.in);
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		System.out.println("Dorsal del ciclista:");
		dorsal = scannerNum.nextShort();
		System.out.println("Nuevo equipo del ciclista:");
		equipoS = scanner.nextLine();

		try {
			Ciclista ciclista = (Ciclista) session.get(Ciclista.class, dorsal);

			if (ciclista.getEquipo().getNomeq().equals(equipoS)) {
				throw new ArithmeticException();
			}
			ciclista.setEquipo((Equipo) session.get(Equipo.class, equipoS));
			session.save(ciclista);
			session.getTransaction().commit();
		} catch (ArithmeticException e) {
			System.out.println("El ciclista ya forma parte del equipo");
		} catch (NullPointerException e) {
			System.out.println("Equipo o jugador no existen en la BBDD");
		}
		session.close();
	}
}
