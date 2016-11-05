package br.com.loja.modelo;

public class Carro {
	private String nome;
	private int ano;
	private String fabricante;
	private String categoria;
	private double TamanhoTanque;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getTamanhoTanque() {
		return TamanhoTanque;
	}
	public void setTamanhoTanque(double tamanhoTanque) {
		TamanhoTanque = tamanhoTanque;
	}
	
	

}
