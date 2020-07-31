package com.cursos_online;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import com.cursos_online.entidades.Curso;
import com.cursos_online.entidades.Estudiante;
public class Main {
	final static StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	
	static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

	public static void main(String[] args) {
		
	Curso cur1 = new Curso("Fundamentos de Java");
	Curso cur2 = new Curso("Hibernate oara principiantes");
	
	ingresarCurso(cur1);
	ingresarCurso(cur2);
		
	Estudiante estu1 = new Estudiante(0,"Ernesto","Arteaga");
	Estudiante estu2 = new Estudiante(0,"Rosa","Mariam");
	Estudiante estu3 = new Estudiante(0,"Loor","Sanchez");
	
	ingresarestu(estu1);
	ingresarestu(estu2);
	ingresarestu(estu3);
	}
	
	
	static void ingresarCurso(Curso curso){	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(curso);
		
		session.getTransaction().commit();
		session.close();
	}
	
	static void ingresarestu(Estudiante estudiante){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(estudiante);
		
		session.getTransaction().commit();
		session.close();
		//System.out.println(estudiante.getId());
	}

}

