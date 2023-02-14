package org.iesabastos.dam.datos.ijg.interfaz;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.iesabastos.dam.datos.ijg.Ciclista;
import org.iesabastos.dam.datos.ijg.Equipo;
import org.iesabastos.dam.datos.ijg.Utils.HibernateUtil;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class _02dCrearCiclista {
	public static void main(String[] args) {
		String nombre, fecha, equipoS;
		short dorsal;
		Scanner scanner = new Scanner(System.in);
		Scanner scannerNum = new Scanner(System.in);
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		System.out.println("Dorsal del ciclista(en caso de que no exista dicho dorsal):");
		dorsal = scannerNum.nextShort();
		System.out.println("Nombre del ciclista:");
		nombre = scanner.nextLine();
		System.out.println("Nombre del equipo:");
		equipoS = scanner.nextLine();
		System.out.println("Su fecha de nacimiento:(DD-MM-YYYY)");
		fecha = scanner.nextLine();

		try {
			Ciclista ciclista = new Ciclista();
			ciclista.setNombre(nombre);
			ciclista.setNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse(fecha));
			try {
				Ciclista c = (Ciclista) (session.get(Ciclista.class, dorsal));

			} catch (Exception e) {
				//no encuentra dorsal, por tanto define el que el usuario ha pasado
				ciclista.setDorsal(dorsal);
			}


			Equipo equipo = (Equipo) session.get(Equipo.class, equipoS);
			ciclista.setEquipo(equipo);
			session.save(ciclista);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("El ciclista ya existe");
		} catch (NullPointerException e) {
			System.out.println("Equipo no existe en la BBDD");
		} catch (ParseException e) {
			System.out.println("Se ha introducido la fecha con el formato incorrecto");
		}
		session.close();
	}
}

