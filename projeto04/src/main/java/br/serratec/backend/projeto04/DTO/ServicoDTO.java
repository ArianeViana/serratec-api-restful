package br.serratec.backend.projeto04.DTO;

import java.time.LocalDate;

public class ServicoDTO {
	
	private Integer idServico;
	private Double valorServico;
	private String servicoPrestado;
	private LocalDate dataServico;
	private Integer idCarro;
	
	public ServicoDTO() {
		
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

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	
	
}
