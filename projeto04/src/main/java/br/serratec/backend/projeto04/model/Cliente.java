package br.serratec.backend.projeto04.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cliente_cd_id")
	private Integer idCliente;
	
	@Column(name="cliente_tx_nome")
	@NotNull
	private String nomeCliente;
	
	@Column(name="cliente_tx_cpf")
	private String cpfCliente;
	
	@Column(name="cliente_tx_telefone")
	@NotNull
	private String telefoneCliente;
	
	@Column(name="cliente_tx_email")
	private String emailCliente;
	
	@OneToMany(mappedBy="cliente", cascade = CascadeType.REMOVE)
	private List<Carro> listaCarros;
	
	public Cliente() {
		
	}

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

	public void setListaCarros(List<Carro> listaCarros) {
		this.listaCarros = listaCarros;
	}
	
	
	
}
