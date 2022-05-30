package br.serratec.backend.projeto04.DTO;

import java.util.List;

import br.serratec.backend.projeto04.model.Servico;

public class CarroExibicaoDTO {
	
	private Integer idCarro;
	private String modeloCarro;
	private String marcaCarro;
	private Integer anoCarro;
	private Integer idCliente;
	private List<Servico> listaServico;
	
	public CarroExibicaoDTO() {
		
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

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public List<Servico> getListaServico() {
		return listaServico;
	}

	public void setListaServico(List<Servico> listaServico) {
		this.listaServico = listaServico;
	}
	
	
	
	
}
