package br.com.fiap.loja.controller;

import br.com.fiap.loja.model.Cliente;
import br.com.fiap.loja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;



    @GetMapping("buscar")
    public String buscar(String termoBusca, Model model){
        model.addAttribute("clientes",
                repository.findByNomeContainsIgnoreCaseOrCpfContains(termoBusca,termoBusca));
        return "cliente/lista";
    }

    @GetMapping("listar")
    public String listar(){
        return "cliente/lista";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Cliente cliente){
        return "cliente/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirect){
        if (result.hasErrors()) { //se existir erros de validações
            return "cliente/form"; //retorna para a página de cadastro
        }
        repository.save(cliente);
        redirect.addFlashAttribute("msg","Cadastrado!");
        return "redirect:/cliente/cadastrar";
    }


}
