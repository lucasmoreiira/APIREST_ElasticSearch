package com.example.demo.controller;


import com.example.demo.domain.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public Iterable<Produto> buscarProdutos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable("id") String id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return service.salvar(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        return service.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable("id") String id){
        service.deletar(id);
    }

}
