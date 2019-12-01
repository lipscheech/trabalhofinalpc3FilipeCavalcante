package br.com.prog3.trabalhofinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "imagem")
	private String imagem;
	
	@Column(name = "garantia")
	private String garantia;
	
	@Column(name = "fabricante")
	private String fabricante;
	
	@Column(name = "precoCompra")
	private Double precoCompra;
	
	@Column(name = "precoVenda")
	private Double precoVenda;
	
	@Column(name = "desconto")
	private Double desconto;
	
	
	
	public Produto() {
		
	}

	public Produto(String nome, String descricao, String fabricante,
			Double precoCompra, Double precoVenda, Double desconto) {
		this.nome = nome;
		this.descricao = descricao;;
		this.fabricante = fabricante;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.desconto = desconto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	
	
	

}
