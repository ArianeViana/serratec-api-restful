package br.serratec.backend.exercicio04.DTO;

import java.time.LocalDate;
import java.util.Date;

public class LivroDTO {
	 
	private Integer idLivro;
	private String tituloLivro;
	private String autorLivro;
	private String categoriaLivro;
	private LocalDate dataPublicacao;
	
	public LivroDTO() {
		
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

	public void setDataPublicacao(LocalDate localDate) {
		this.dataPublicacao = localDate;
	}
	
	
}

