package br.serratec.backend.projeto04.DTO;

import java.util.List;

import br.serratec.backend.projeto04.model.Carro;

public class ClienteExibicaoDTO {
	
	private Integer idCliente;
	private String nomeCliente;
	private String cpfCliente;
	private String telefoneCliente;
	private String emailCliente;
	private List<Carro>	listaCarros;
	
	
	public ClienteExibicaoDTO() {
		
	}
	
		
//	public ClienteExibicaoDTO(Integer idCliente, String nomeCliente, String cpfCliente, String telefoneCliente,
//			String emailCliente, List<Carro> listaCarros) {
//		super();
//		this.idCliente = idCliente;
//		this.nomeCliente = nomeCliente;
//		this.cpfCliente = cpfCliente;
//		this.telefoneCliente = telefoneCliente;
//		this.emailCliente = emailCliente;
//		this.listaCarros = listaCarros;
//	}




	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public List<Carro> getListaCarros() {
		return listaCarros;
	}
	public void setListaCarros(List<Carro> listaCarro) {
		this.listaCarros = listaCarro;
	}
	
	
	
	
	
	
}
