package model;

import java.sql.Date;
import java.time.LocalDate;

public class Pet { 

	private int id;
	private String nome;
	private String especie;
	private String porte;
	private String raca;
	private String alergia;
	private String problemaSaude;
	private String observacao;
	private String sexo;
	private String medicamento;
	private int perfume;
	private int castrado;
	private String nomeDono;
	private LocalDate vermifugado;
	private LocalDate v8;
	private LocalDate antirabica;
	private Cliente cliente;	

		
	public Date getVermifugado() {		
		Date date = Date.valueOf(vermifugado);
		return date;
	}


	public void setVermifugado(LocalDate localDate) {
		this.vermifugado = localDate;
	}


	public Date getV8() {
		Date date = Date.valueOf(v8);
		return date;
	}


	public void setV8(LocalDate v8) {
		this.v8 = v8;
	}


	public Date getAntirabica() {
		Date date = Date.valueOf(antirabica);
		return date;	
	}


	public void setAntirabica(LocalDate antirabica) {
		this.antirabica = antirabica;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public String getPorte() {
		return porte;
	}


	public void setPorte(String porte) {
		this.porte = porte;
	}


	public String getRaca() {
		return raca;
	}


	public void setRaca(String raca) {
		this.raca = raca;
	}


	public String getAlergia() {
		return alergia;
	}


	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}


	public String getProblemaSaude() {
		return problemaSaude;
	}


	public void setProblemaSaude(String problemaSaude) {
		this.problemaSaude = problemaSaude;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getMedicamento() {
		return medicamento;
	}


	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}


	public int getPerfume() {
		return perfume;
	}


	public void setPerfume(int perfume) {
		this.perfume = perfume;
	}


	public int getCastrado() {
		return castrado;
	}


	public void setCastrado(int castrado) {
		this.castrado = castrado;
	}


	public String getNomeDono() {
		return nomeDono;
	}


	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	
	
}
