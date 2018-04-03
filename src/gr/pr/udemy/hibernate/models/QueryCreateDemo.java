package gr.pr.udemy.hibernate.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryCreateDemo {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			List<StudentModel> students = session.createQuery("from StudentModel").list();
			
			printStudents(students);
			
			students = session.createQuery("from StudentModel s where s.lastName = 'R'").list();
			
			printStudents(students);
			
			students = session.createQuery("from StudentModel s where s.email like '%.gr'").list();
			
			printStudents(students);
			
			students = session.createQuery("from StudentModel s where s.lastName = 'Doe' or s.firstName = 'Makis'").list();
			
			printStudents(students);
			
			session.getTransaction().commit();
		}
		finally {
			if (session != null) {
				session.close();
			}
			
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}
	
	private static void printStudents(List<StudentModel> students) {
		
		System.out.println("\n");
		for (StudentModel student : students) {
			System.out.println(student);
		}
	}
}
