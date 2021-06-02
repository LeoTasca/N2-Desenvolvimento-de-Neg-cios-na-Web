package br.edu.cesusc.model;

public class Cliente {
	protected int id;
	protected int matricula;
	protected String nome;
	protected String bairro;
	protected String cidade;
	protected String cep;
	protected String estado;
	protected String logradouro;
	protected String numero;
	protected String modalidade;
	protected String descricao;
		
	public Cliente() {
		super();
	}

	public Cliente(int id, int matricula, String nome, String bairro, String cidade, String cep, String estado, String logradouro, String numero, String modalidade, String descricao) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
		this.logradouro = logradouro;
		this.numero = numero;
		this.modalidade = modalidade;
		this.descricao = descricao;
	}

	public Cliente(int matricula, String nome, String bairro, String cidade, String cep, String estado, String logradouro, String numero, String modalidade, String descricao) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
		this.logradouro = logradouro;
		this.numero = numero;
		this.modalidade = modalidade;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
