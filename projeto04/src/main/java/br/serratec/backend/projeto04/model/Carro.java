package br.serratec.backend.projeto04.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="carro")
public class Carro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="carro_cd_id")
	private Integer idCarro;
	
	@Column(name="carro_tx_marca")
	private String marcaCarro;
	
	@Column(name="carro_tx_modelo")
	private String modeloCarro;	
	
	@Column(name="carro_num_ano")
	private Integer anoCarro;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="cliente_cd_id")
	@JsonIgnore
	private Cliente cliente;
	
	@OneToMany(mappedBy="carro")
	private List<Servico> listaServico;	
	
		
	public Carro() {
		
	}
	

	public Integer getIdCarro() {
		return idCarro;
	}



	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}



	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getMarcaCarro() {
		return marcaCarro;
	}

	public void setMarcaCarro(String marcaCarro) {
		this.marcaCarro = marcaCarro;
	}

	public Integer getAnoCarro() {
		return anoCarro;
	}

	public void setAnoCarro(Integer anoCarro) {
		this.anoCarro = anoCarro;
	}



	public Cliente getCliente() {
		return cliente;
	}

	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Servico> getListaServico() {
		return listaServico;
	}


	public void setListaServico(List<Servico> listaServico) {
		this.listaServico = listaServico;
	}
	
	

		
}
