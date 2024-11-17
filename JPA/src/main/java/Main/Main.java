package Main;
//Imports das informações dos outros pacotes e um scanner para preencher informações
import Dao.ProdutoDAO;
import Model.Produto;

import java.util.Scanner;

//A classe main será onde o usuário irá preencher as informações (nome e preço)
public class Main {
	public static void main(String[] args) {	
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Scanner scanner = new Scanner(System.in);
		
		//Enquanto o usuário escrever sim, o programa continua
		String continuar = "sim";
		while(continuar.equalsIgnoreCase("sim")) {
			//Solicitar dados para o usuário preencher
			Produto produto = new Produto();
			System.out.print("Digite o nome do produto: ");
			produto.setNome(scanner.nextLine());
			
			System.out.print("Digite o preço do produto: ");
			produto.setPreco(scanner.nextDouble());
			scanner.nextLine(); //Consome a quebra de linha
			
			//Irá criar o produto na classe produtoDAO, agora sendo possivel colocá-lo no banco de dados
			produtoDAO.criar(produto);
			
			System.out.print("Deseja adicionar outro produto? (sim/não) ");
			continuar = scanner.nextLine(); 	
		}
		
	//Irá demonstrar todos os produtos inseridos na lista
	System.out.println("\n Lista de produtos no banco de dados: ");
	produtoDAO.listarTodos().forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));

	scanner.close();

	}
}	

