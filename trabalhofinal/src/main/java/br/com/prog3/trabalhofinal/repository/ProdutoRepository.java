package br.com.prog3.trabalhofinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.prog3.trabalhofinal.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	List<Produto> findAll();

}
