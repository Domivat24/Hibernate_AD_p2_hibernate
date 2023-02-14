package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Etapa;

import java.util.Scanner;

import static org.iesabastos.dam.datos.ijg.Utils.HibernateUtil.*;

public class _01c01GanadorDeEtapa {
	public static void main(String[] args) {
		{
			Scanner scanner = new Scanner(System.in);
			buildSessionFactory();
			openSession();

			Session session = getCurrentSession();
			session.beginTransaction();
			//scanner
			short id;
			id = scanner.nextShort();
			Ciclista ciclista = ((Etapa) session.get(Etapa.class, id)).getGanador();
			System.out.println(ciclista);
			session.close();
		}
	}
}
