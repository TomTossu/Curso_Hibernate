package com.arteysoft.hbn;

import org.hibernate.SessionFactory;

public class App 
{
    public static void main( String[] args )
    {
        HibernateConfiguration hibernateConfiguration = new 
            HibernateConfiguration();
        
        SessionFactory sessFac = hibernateConfiguration.configure();
        
        UsuarioRepository usuarioRepository = new UsuarioRepository(sessFac); 
        
        UsuarioQueries consultas = new UsuarioQueries(sessFac);
        
        for (Usuario u : consultas.obtenerTodosLosUsuarios()) {
        	System.out.println(u);
        	System.out.println(u.getNombre());
        	System.out.println(u.getApellido());
        }
        
        for(Object o : consultas.obtenerSoloAlgunasColumnas()) {
        	System.out.println(o);
        }
        
        for(DosCampos dc : consultas.obtenerCuenta()) {
        	System.out.println(dc.cuenta);
        	System.out.println(dc.nombre);
        }
        //Usuario usuario = new Usuario(java.util.UUID.randomUUID().toString(), "UsuarioRepetido", "Rep");
		
		//usuarioRepository.grabar(usuario);
		
		/*
		usuarioRepository.obtener("d6f60ad6-1027-4192-bb7f-879074da0b49");	
		*/	
        sessFac.close();
    }
}
