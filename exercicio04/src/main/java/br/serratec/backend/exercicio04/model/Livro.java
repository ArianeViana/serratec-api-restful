package br.serratec.backend.exercicio04.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="livro_cd_id")
	private Integer idLivro;
	
	@Column(name="livro_tx_titulo")
	@NotNull
	@Size(min = 5, max = 30)
	private String tituloLivro;
	
	@Column(name="livro_tx_autor")
	@NotNull
	@Size(min = 10, max = 40)
	private String autorLivro;
	
	@Column(name="livro_tx_categoria")
	@NotNull
	@Size(min = 3, max = 20)
	private String categoriaLivro;
	
	@Column(name="livro_dt_publicacao")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private LocalDate dataPublicacao;
	
	
	public Livro() {
		
	}

	
	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	public String getCategoriaLivro() {
		return categoriaLivro;
	}

	public void setCategoriaLivro(String categoriaLivro) {
		this.categoriaLivro = categoriaLivro;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	
}
