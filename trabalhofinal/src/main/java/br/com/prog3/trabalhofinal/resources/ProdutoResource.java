package br.com.prog3.trabalhofinal.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.trabalhofinal.domain.Produto;
import br.com.prog3.trabalhofinal.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoResource{

	@Autowired
	private ProdutoService produtoService;

	@PostMapping
	public Produto save(@RequestBody Produto curso) {
		return produtoService.save(curso);
	}

	@GetMapping
	public List<Produto> findAll() {
		return produtoService.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public Optional<Produto> findById(@PathVariable("id") Long id) {
		return produtoService.findById(id);
	}

	@PutMapping(value = "/{id}")
	public Produto update(@PathVariable("id") Long id, @RequestBody Produto produto) {
		Optional<Produto> optional = produtoService.findById(id);
		if (optional.isPresent()) {
			Produto p = optional.get();
			p.setDesconto(produto.getDesconto());
			p.setNome(produto.getNome());
			p.setPrecoCompra(produto.getPrecoCompra());
			p.setPrecoVenda(produto.getPrecoVenda());
			produtoService.update(p);
			return p;
		} else {
			throw new RuntimeException("Não foi possível alterar registro");
		}
	}

	@DeleteMapping(path = { "/{id}" })
	public void delete(@PathVariable("id") Long id) {
		produtoService.deleteById(id);
	}

}
