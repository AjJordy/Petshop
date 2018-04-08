package model;

import java.util.LinkedList;

public class Cliente { 

	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private String celular;
	private String email;
	private String endereco;	
	private int whatsapp;
	private LinkedList pets;



	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public LinkedList getPets() {
		return pets;
	}


	public void setPets(LinkedList pets) {
		this.pets = pets;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getWhatsapp() {
		return whatsapp;
	}


	public void setWhatsapp(int whatsapp) {
		this.whatsapp = whatsapp;
	}


	
	
	

	
}
