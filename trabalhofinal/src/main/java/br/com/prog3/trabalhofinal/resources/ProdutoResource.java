package br.com.prog3.trabalhofinal.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProdutoResource{

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/produtos")
	public List<Produto> getAllProdutos(){
		List<Produto> produto = new ArrayList<>();
		produtoService.findAll().forEach(produto::add);
		return produto;
	}

	@PostMapping("/produto")
	public Produto postProduto(@RequestBody Produto produto) {
		Produto _produto = produtoService.save(new Produto(produto.getNome(), produto.getDescricao(), produto.getFabricante(), produto.getPrecoCompra(), produto.getPrecoVenda(), produto.getDesconto()));
		return _produto;
	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<String> deleteCliente(@PathVariable("id") long id){
		produtoService.deleteById(id);
		return new ResponseEntity<>("Produto deletado !", HttpStatus.OK);
	}
}
