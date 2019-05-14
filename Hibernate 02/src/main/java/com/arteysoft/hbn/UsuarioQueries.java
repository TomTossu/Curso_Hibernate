package com.arteysoft.hbn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UsuarioQueries {
	private SessionFactory sessionFactory;

	public UsuarioQueries(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public List<Usuario> obtenerTodosLosUsuarios(){
		//from Usuario
		//from Usuario u
		//from Usuario u where u.nombre 'Tomas'
		
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Usuario u where u.nombre = 'Tomas'");
		List<Usuario> ret = q.list();
		
		session.close();

		return ret;
	}
	
	public List<Object[]> obtenerSoloAlgunasColumnas(){
		//select count(*), nombre from Usuario u group by u.nombre
		
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("select count(*), nombre from Usuario u group by u.nombre");
		List<Object[]> ret = q.list();
		
		session.close();

		return ret;
	}
	
	public List<DosCampos> obtenerCuenta(){
		//select new "nombre del paquete".DosCampos(count(*) as cuenta, u.nombre) from Usuario u group by u.nombre
		
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("select new com.arteysoft.hbn.DosCampos(count(*) as cuenta, u.nombre) from Usuario u group by u.nombre");
		List<DosCampos> ret = q.list();
		
		session.close();

		return ret;
	}
	
}
