package br.serratec.backend.projeto04.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_cd_id")
	private Integer idUsuario;
	
	@Column(name = "usuario_tx_login")
	private String loginUsuario;
	
	@Column(name = "usuario_tx_senha")
	private String senhaUsuario;

	
	
	public Usuario() {
	
	}



	public Integer getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getLoginUsuario() {
		return loginUsuario;
	}



	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}



	public String getSenhaUsuario() {
		return senhaUsuario;
	}



	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	
	
	
	
	
	
}
