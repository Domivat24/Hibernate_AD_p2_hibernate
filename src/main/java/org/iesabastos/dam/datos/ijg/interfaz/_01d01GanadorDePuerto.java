package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Puerto;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.Scanner;

public class _01d01GanadorDePuerto {
	public static void main(String[] args) {
		{
			{
				{
					Scanner scanner = new Scanner(System.in);
					HibernateUtil.buildSessionFactory();
					HibernateUtil.openSession();

					Session session = HibernateUtil.getCurrentSession();
					session.beginTransaction();
					String puerto;
					puerto = scanner.nextLine();
					Puerto puerto1 = (Puerto) session.get(Puerto.class, puerto);
					System.out.println(puerto1.getGanador().getNombre()
					);
					session.close();

				}
			}
		}
	}
}
