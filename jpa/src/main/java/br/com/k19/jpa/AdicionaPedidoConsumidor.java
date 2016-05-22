package br.com.k19.jpa;

import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaPedidoConsumidor {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Consumidor c = new Consumidor();
		Pedido p = new Pedido();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o nome do consumidor: ");
		c.setNome(entrada.nextLine());
		
		p.setData(Calendar.getInstance());
		//p.setConsumidor(c);
		
		c = manager.find(Consumidor.class, 1l);
		p.setConsumidor(c);
		
		entrada.close();
		
		manager.persist(c);
		manager.persist(p);
		
		entrada.close();
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		
	}
}
