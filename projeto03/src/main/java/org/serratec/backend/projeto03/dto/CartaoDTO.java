package org.serratec.backend.projeto03.dto;

import java.io.Serializable;

import java.time.LocalDate;

import org.serratec.backend.projeto03.model.Cliente;

public class CartaoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idCartao;
	private Double limiteCartao;
	private String numeroCartao;
	private String nomeTitular;
	private LocalDate dataValidade;
	private Integer idCliente;	
	
	public CartaoDTO() {
		
	}

	public Integer getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Integer idCartao) {
		this.idCartao = idCartao;
	}

	public Double getLimiteCartao() {
		return limiteCartao;
	}

	public void setLimiteCartao(Double limiteCartao) {
		this.limiteCartao = limiteCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
}
