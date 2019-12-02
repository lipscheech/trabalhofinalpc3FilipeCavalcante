package br.com.prog3.trabalhoFinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.trabalhoFinal.domain.Produto;
import br.com.prog3.trabalhoFinal.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<Produto> finAll() {
		return (List<Produto>) produtoRepository.findAll();
	}

	public Optional<Produto> finById(Long id) {
		return produtoRepository.findById(id);
	}

	public Produto update(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void deleteById(Long id) {
		produtoRepository.deleteById(id);
	}
}
