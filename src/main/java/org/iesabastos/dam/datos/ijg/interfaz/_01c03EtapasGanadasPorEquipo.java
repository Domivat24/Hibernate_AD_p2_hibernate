package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Equipo;
import org.iesabastos.dam.datos.ijg.Etapa;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.util.Scanner;

public class _01c03EtapasGanadasPorEquipo {
	public static void main(String[] args) {
		{
			{
				Scanner scanner = new Scanner(System.in);
				HibernateUtil.buildSessionFactory();
				HibernateUtil.openSession();

				Session session = HibernateUtil.getCurrentSession();
				session.beginTransaction();
				//scanner
				String team;
				team = scanner.nextLine();
				Equipo equipo = (Equipo) session.get(Equipo.class, team);

				for (Ciclista c : equipo.getCiclistas()
				) {
					System.out.printf("Ciclista %s ha ganado %d\n", c.getNombre(), c.getEtapasGanadas().size());
				}
				session.close();

			}
		}
	}
}
