package br.com.nicole.crudCinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // uma tabela do banco
public class Filmes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Campo Obrigatorio!") // obriga o usuario a incluir um nome pro filme.
	@Size(min = 2, max = 254, message = "Nome deve conter entre 2 e 254 caracteres")
	private String nome;

	private String decricao;
	private String urlImg;
	private String urlFilmes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDecricao() {
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public String getUrlFilmes() {
		return urlFilmes;
	}

	public void setUrlFilmes(String urlFilmes) {
		this.urlFilmes = urlFilmes;
	}

	
}
