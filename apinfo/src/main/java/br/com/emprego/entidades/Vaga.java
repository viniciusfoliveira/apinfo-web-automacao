package br.com.emprego.entidades;

import java.io.Serializable;
import java.util.Date;


public class Vaga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String estado;
	
	private String capital;
	
	private Date data;
	
	private String cargo;
	
	private String descricao;
	
	private String empresa;

	public Vaga() {}
	
	public Vaga(String estado, String capital, Date data, String cargo, String descricao, String empresa) {
		super();
		this.estado = estado;
		this.capital = capital;
		this.data = data;
		this.cargo = cargo;
		this.descricao = descricao;
		this.empresa = empresa;
	}
	
	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
}
