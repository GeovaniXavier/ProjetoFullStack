
package Estoque.groupacp.controller;

import Estoque.groupacp.model.Produto;
import Estoque.groupacp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    //ListarTodos
    @GetMapping
    public ResponseEntity<List<Produto>> listaProduto() {
        List<Produto> produtos = produtoRepository.findAll();
        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }
    // Inclusão de um produto;
    @PostMapping
    public ResponseEntity<Produto> incluir(@RequestBody Produto produto) {
        Produto user = produtoRepository.save(produto);
        return new ResponseEntity<Produto>(user, HttpStatus.CREATED);
    }

    //Alteração de um produto por id;
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Produto produto) {

        if (produto.getId() == null) {
            return new ResponseEntity<String>("Id não foi informado.", HttpStatus.OK);
        }
        produtoRepository.findById(produto.getId())
        .orElseThrow(() -> new  RuntimeException("Id não encontrado."));
        Produto user = produtoRepository.saveAndFlush(produto);
        return new ResponseEntity<Produto>(user, HttpStatus.OK);
    }
    //Excluir um produto por id;
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);

        return new ResponseEntity<String>("Usuario deletado com sucesso!", HttpStatus.OK);
    }

    //Mostrar Por nome
    @ResponseBody
    @GetMapping(value = "byName")
    public ResponseEntity<List<Produto>> buscarPorNome(@RequestParam(name = "name") String name) {

        List<Produto> produto = produtoRepository.buscarPorNome(name.trim().toUpperCase());
        return new ResponseEntity<List<Produto>>(produto, HttpStatus.OK);
    }

    //Excluir vários produtos;
    @DeleteMapping
    public void deleteAll(@RequestBody List<Long> ids) {
        produtoRepository.deleteAllById(ids);
    }
}
