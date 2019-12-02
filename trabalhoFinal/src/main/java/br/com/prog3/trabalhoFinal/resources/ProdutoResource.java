package br.com.prog3.trabalhoFinal.resources;

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

import br.com.prog3.trabalhoFinal.domain.Produto;
import br.com.prog3.trabalhoFinal.service.ProdutoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/produtos")
	public List<Produto> getAllProdutos(){
		List<Produto> produto = new ArrayList<>();
		produtoService.finAll().forEach(produto::add);
		return produto;
	}
	
	@PostMapping("/produto")
	public Produto postProduto(@RequestBody Produto produto) {
		Produto _produto = produtoService.save(new Produto(produto.getNome(), produto.getDescricao(), produto.getFabricante()));
		return _produto;
	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<String> deleteProduto(@PathVariable("id") long id){
		produtoService.deleteById(id);
		return new ResponseEntity<>("Produto deletado com sucesso !", HttpStatus.OK);
	}
	
	@PutMapping("/produto/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable("id") long id, @RequestBody Produto produto){
		Optional<Produto> dadosProdutos = produtoService.finById(id);
		
		if(dadosProdutos.isPresent()) {
			Produto _produto = dadosProdutos.get();
			_produto.setNome(produto.getNome());
			_produto.setDescricao(produto.getDescricao());
			_produto.setFabricante(produto.getFabricante());
			
			return new ResponseEntity<>(produtoService.save(_produto), HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
