package com.grupo4.hibdemo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class Main {
public static void main(String[] args) {
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	 
	Session session = sessionFactory.openSession();
	Transaction tr = session.beginTransaction();
	SanPosts user = new SanPosts();
	user.setPstContent("Mario");
	session.save(user);
	tr.commit();
	System.out.println("Se guardó satisfactoriamente");
	sessionFactory.close();
}


}
