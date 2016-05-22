package br.com.k19.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaDepartamentoFuncionario {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Scanner entrada = new Scanner(System.in);
		
		Funcionario funcionario = new Funcionario();
		System.out.println("Digite o nome do funcionario: ");
		funcionario.setNome(entrada.nextLine());
		
		//Departamento departamento = new Departamento();
		//System.out.println("Digite o departamento do funcionario: ");
		//departamento.setNome(entrada.nextLine());

		Departamento departamento = manager.find(Departamento.class, 4l);
		departamento.getFuncionarios().add(funcionario);
		entrada.close();

		manager.persist(funcionario);
		manager.persist(departamento);
		
		manager.getTransaction().commit();
		
		System.out.println("Funcioraio " + funcionario.getNome() + " cadastrado  com o id: "+funcionario.getId());
		System.out.println("Departamento " + departamento.getNome() + "cadastrado com o id: "+ departamento.getId());
		
		manager.close();
		factory.close();
		
	}
}
