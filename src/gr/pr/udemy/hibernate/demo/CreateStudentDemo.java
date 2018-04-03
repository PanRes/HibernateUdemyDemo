package gr.pr.udemy.hibernate.demo;

import gr.pr.udemy.hibernate.models.CoursesModel;
import gr.pr.udemy.hibernate.models.StudentModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory =  new Configuration().configure("hibernate.cfg.xml").
											addAnnotatedClass(StudentModel.class).buildSessionFactory();
		
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			CoursesModel student = new CoursesModel("Panagiotis", "Ressos");
			
			session.beginTransaction();
			
			System.out.println("Saving Student \n" + student);
			session.save(student);
			
			System.out.println("Commiting student \n" + student);
			session.getTransaction().commit();
			
			System.out.println("Commit done \n" + student);
			
		}
		finally {
			if (session != null){
				session.close();
			}
			
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
		
	}
}