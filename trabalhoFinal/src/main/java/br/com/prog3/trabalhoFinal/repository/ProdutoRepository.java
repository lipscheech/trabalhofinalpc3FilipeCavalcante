package br.com.prog3.trabalhoFinal.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.prog3.trabalhoFinal.domain.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
