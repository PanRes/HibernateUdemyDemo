package gr.pr.udemy.hibernate.demo;

import gr.pr.udemy.hibernate.models.StudentModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(StudentModel.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		
		try {
			StudentModel studentModel1 = new StudentModel("John","Doe","john@doe.com");
			StudentModel studentModel2 = new StudentModel("Makis","Kotsovos","makis@kotsovos.com");
			session.beginTransaction();

			session.save(studentModel1);
			session.save(studentModel2);
			
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
}