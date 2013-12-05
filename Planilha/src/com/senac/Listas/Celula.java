package com.senac.Listas;

public class Celula {

	String formula;
	double valor;
	String nome;
	
	public Celula(){
		this.nome = nome;
		this.formula = formula;
		this.valor = valor;
		
	}
	public void setformula(String formula) {
		this.formula = formula;
	}
	
	public void setnome(String nome) {
		this.nome = nome;
	}
	
   public String getformula() {
		return formula;
	}
	public double getvalor() {
		return valor;
	}
	public String getnome(String nome) {
		return nome;
	}
	
}
