package br.com.loja.modelo;

import java.util.Calendar;

public class Cliente {
	private long id;
	private String nome;
	private String telefone;
	private String cpf;
	private String endereco;
	Calendar dataNascimento;
	
//	public Cliente(long id, String nome, String telefone, String cpf, String endereco, Calendar dataNascimento){
//		this.id = id;
//		this.nome = nome;
//		this.telefone = telefone;
//		this.cpf = cpf;
//		this.endereco = endereco;
//		this.dataNascimento = dataNascimento;		
//	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

}
