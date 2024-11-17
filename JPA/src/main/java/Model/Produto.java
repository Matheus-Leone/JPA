package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Identifica para o banco de dados que essa classe é uma entidade
public class Produto {
	@Id //Especifica a um produto uma chave primária, o tornando único
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Gera as chaves primárias para os produtos no banco de dados
	//Atributos dos produtos
	private Long id;
	private String nome;
	private Double preco;
		
	//Get and Setters para puxar essas informações quando necessário
	public Long getId(){
	return id;
	}
	
	public void setId(Long id){
	this.id = id;	
	}
	
	public String getNome(){
	return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;	
		}

	public Double getPreco(){
	return preco;
	}
	
	public void setPreco(Double preco){
		this.preco = preco;	
		}
	
}
