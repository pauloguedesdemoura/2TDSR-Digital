package br.com.fiap.gravadora.controller;

import br.com.fiap.gravadora.model.Gravadora;
import br.com.fiap.gravadora.repository.GravadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("gravadora")
public class GravadoraController {

    @Autowired
    private GravadoraRepository rep;

    @GetMapping("buscarGravadoras")
    public String buscar(String termoPesquisa, Model model){
        model.addAttribute("gravadoras", rep.findByNomeContainsIgnoreCase(termoPesquisa));
        return "gravadora/lista";
    }

    @PostMapping("excluir")
    public String deletar(int id, RedirectAttributes redirect){
        rep.deleteById(id);
        redirect.addFlashAttribute("mensagem","Removido com sucesso!");
        return "redirect:/gravadora/listar";
    }

    @PostMapping("editar")
    public String editar(Gravadora gravadora, RedirectAttributes redirect){
        //atualizar a gravadora no banco
        rep.save(gravadora);
        //mandar a mensagem para a tela
        redirect.addFlashAttribute("mensagem","Atualizado!");
        //redirecionar para a tela de listagem
        return "redirect:/gravadora/listar"; //URL
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id")int codigo, Model model){
        //Pesquisa a gravadora no banco de dados
        Gravadora g = rep.findById(codigo).get();
        //Enviar a gravadora para a tela
        model.addAttribute("gravadora",g); // chave/variável -> th:object do formulário
        //retornar a página
        return "gravadora/edicao";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Gravadora gravadora, RedirectAttributes redirect){
        //cadastrar/salvar a gravadora no banco de dados
        rep.save(gravadora);
        //mandar uma mensagem para a tela
        redirect.addFlashAttribute("mensagem","Cadastrado!");
        //retornar a página
        return "redirect:/gravadora/listar"; //URL
    }

    @GetMapping("cadastrar")
    public String cadastrar(Gravadora gravadora){
        return "gravadora/form";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("gravadoras",rep.findAll());
        return "gravadora/lista";
    }

}
