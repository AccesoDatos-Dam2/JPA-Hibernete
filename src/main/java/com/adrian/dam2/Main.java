package com.adrian.dam2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
// Atributo estático para deshabilitar el logger de hibernate
private static final Logger LOG_HIBERNATE = Logger.getLogger("org.hibernate");


	public static void main(String[] args) {
	 // Le decimos a hibernate que solo muestre los errores y no mensajes informativos
	 LOG_HIBERNATE.setLevel(Level.SEVERE);

	 EntityManagerFactory emf =Persistence.createEntityManagerFactory("clasePU");
	 EntityManager em = emf.createEntityManager();
	 try{
		 
		 String jpql="FROM Producto p where p.nombre LIKE 'Teclado%' ORDER BY p.precio DESC";
		 List<Producto>lista= em.createQuery(jpql,Producto.class).getResultList();
		 for(Producto p:lista) {
			 System.out.println(p);
		 }
		 System.out.println("Total de productos en la tabla: "+ lista.size());
		 //em.getTransaction().begin();
		 /*Producto p = new Producto("Teclado", 25.50);
		 em.persist(p);
		 p = new Producto("Teclado Mecanico", 27.35);
		 em.persist(p);
		 p = new Producto("Ratón", 12.75);
		 em.persist(p);
		 p = new Producto("Fuente de alimentación", 28.24);
		 em.persist(p);
		 p = new Producto("Monitor 21\"", 108.32);
		 em.persist(p);
		 em.persist(new Producto("Caja minitorre",31.60));
		 */
		 //em.getTransaction().commit();
	 }catch(Exception e) {
		 System.out.println("ERROR: "+e.getMessage());
		 //em.getTransaction().rollback();
	 }
	 em.close();
	 emf.close();
	 }
}
	
