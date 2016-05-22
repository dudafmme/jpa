package br.com.k19.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaLivroAutor {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Autor a = new Autor();
		Livro l = new Livro();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o nome do autor:" );
		a.setNome(entrada.nextLine());
		
		System.out.println("Digite o nome  do livro: ");
		l.setNome(entrada.nextLine());
		//l.getAutores().add(a);
		
		entrada.close();
		
		manager.persist(a);
		manager.persist(l);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
