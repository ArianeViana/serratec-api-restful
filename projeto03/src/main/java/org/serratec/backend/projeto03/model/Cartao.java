package org.serratec.backend.projeto03.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cartao")
public class Cartao {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="cartao_cd_id")
		private Integer idCartao;
		
		@Column(name="cartao_limite")
		private Double limiteCartao;
		
		@Column(name="cartao_numero")
		private String numeroCartao;
		
		@Column(name="cartao_nome_titular")
		private String nomeTitular;
		
		@Column(name="cartao_data_validade")
		private LocalDate dataValidade;
		
		@ManyToOne
		@JoinColumn(name="cliente_id", referencedColumnName="cliente_cd_id")
		@JsonIgnore
		private Cliente cliente;
		
//		@OneToOne
//		JoinColumn(name="cliente_id")
//		private Cliente cliente;
		
		
//		@ManyToMany
//		@JoinTable(name="cliente_rel_aviso", joinColumns = {@JoinColumn(name="cartao_id")},
//		inverseJoinColumns = {@JoinColumn(name="aviso_id")})
//		private List<Aviso> listaAviso;

		public Cartao() {
			
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

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}	
		
		
	}

