package br.serratec.backend.projeto04.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="servicoBorracharia")
public class Servico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="servico_cd_id")
	private Integer idServico;
	
	@Column(name="servico_num_valor")
	@NotNull
	private Double valorServico;
	
	@Column(name="servico_prestado")
	@NotNull
	private String servicoPrestado;
	
	@Column(name="servico_dt_data")
	@NotNull
	private LocalDate dataServico;
	
	@ManyToOne
	@JoinColumn(name="carro_id", referencedColumnName = "carro_cd_id")
	@JsonIgnore
	private Carro carro;
	
	public Servico() {
		
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public Double getValorServico() {
		return valorServico;
	}

	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}

	public String getServicoPrestado() {
		return servicoPrestado;
	}

	public void setServicoPrestado(String servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}

	public LocalDate getDataServico() {
		return dataServico;
	}

	public void setDataServico(LocalDate dataServico) {
		this.dataServico = dataServico;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	
}
