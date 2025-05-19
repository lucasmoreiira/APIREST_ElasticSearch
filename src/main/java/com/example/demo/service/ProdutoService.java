package com.example.demo.service;

import com.example.demo.domain.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public Iterable<Produto> listarTodos(){
       return repository.findAll();
    }

    public Produto buscarPorId(String id){
        return repository.findById(id).orElse(null);
    }

    public Produto atualizar(String id, Produto produto){
        produto.setId(id);
        return repository.save(produto);
    }

    public void deletar(String id){
        repository.deleteById(id);
    }

}
