package com.arteysoft.hbn;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UsuarioRepository {
	private SessionFactory sessionFactory;

	public UsuarioRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void grabar(Usuario usuario) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(usuario);
			tx.commit();
		}
		catch(RuntimeException ex){
			System.out.println(ex.toString());
			tx.rollback();
		}
		finally {
			session.close();
		}
	}
	
	public void update(Usuario usuario) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(usuario);
			tx.commit();
		}
		catch(RuntimeException ex) {
			System.out.println(ex.toString());
			tx.rollback();
		}
		finally {
			session.close();
		}
		
	}
	
	public Usuario obtener(String id) {
		Session session = sessionFactory.openSession();
		Usuario usuario = session.get(Usuario.class, id);
		session.close();
		return usuario;
	}
}
