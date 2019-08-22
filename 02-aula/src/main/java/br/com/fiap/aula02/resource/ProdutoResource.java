package br.com.fiap.aula02.resource;

import br.com.fiap.aula02.entity.Produto;
import br.com.fiap.aula02.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository rep;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto cadastrar(@RequestBody Produto produto){
        return rep.save(produto);
    }

    @GetMapping
    public List<Produto> listar(){
        return rep.findAll();
    }

    @GetMapping("{id}")
    public Produto buscar(@PathVariable int id){
        return rep.findById(id).get();
    }

    @PutMapping("{id}")
    public Produto alterar(Produto produto, @PathVariable int id){
        produto.setCodigo(id);
        return rep.save(produto);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo){
        rep.deleteById(codigo);
    }

}
