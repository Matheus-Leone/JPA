package Dao;

//imports de bibliotecas e de outra classe
import Model.Produto;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

//Criação da classe e do Gerenciador de Entidade (que irá gerenciar a classe produto, como foi especificado na classe Produto)
public class ProdutoDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory ("produtoPU");
	
	//Método de Criação de produto (CREATE)
	public void criar (Produto produto) {
		EntityManager em = emf.createEntityManager();	
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
	}
	
	//Método de Leitura de produto (READ)
	public Produto Ler (Long id) {
		EntityManager em = emf.createEntityManager();
		Produto produto = em.find(Produto.class, id);
		em.close();
		return produto;
	}
	
	//Método de irá listar todos os produtos adicionados no banco de dados
	public List<Produto> listarTodos(){
		EntityManager em = emf.createEntityManager();
		List<Produto> produtos = em.createQuery("FROM Produto", Produto.class).getResultList();
		em.close();
		return produtos;
			
	}
	//Método de Criação de produto (UPDATE)
	public void atualizar(Produto produto) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		em.close();
		
		
	}
	
	//Método de Remoção de produto (DELETE)
	public void excluir(Long id) {
		EntityManager em = emf.createEntityManager();
		Produto produto = em.find(Produto.class, id);
		if (produto != null) {
			em.getTransaction().begin();
			em.remove(produto);
			em.getTransaction().commit();
		}
		em.close();
	}
	

}
