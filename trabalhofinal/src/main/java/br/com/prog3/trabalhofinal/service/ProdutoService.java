package br.com.prog3.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.trabalhofinal.domain.Produto;
import br.com.prog3.trabalhofinal.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<Produto> findAll() {
		return (List<Produto>) produtoRepository.findAll();
	}

	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}

	public Produto update(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void deleteById(Long id) {
		produtoRepository.deleteById(id);
	}
}
