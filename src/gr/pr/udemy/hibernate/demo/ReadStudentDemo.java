package gr.pr.udemy.hibernate.demo;

import gr.pr.udemy.hibernate.models.StudentModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
											addAnnotatedClass(StudentModel.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try{
			StudentModel student = new StudentModel("P","R","p@r.gr");
			
			session.beginTransaction();
			System.out.println(student);
			session.save(student);
			System.out.println(student);
			session.getTransaction().commit();
			System.out.println(student);
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			StudentModel studentModel = session.get(StudentModel.class,student.getId());
			
			System.out.println("New student " + studentModel);
			session.getTransaction().commit();
			
			System.out.println(studentModel);
			
			
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
}