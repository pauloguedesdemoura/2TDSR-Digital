package br.com.fiap.esporte.controller;

import br.com.fiap.esporte.model.Modalidade;
import br.com.fiap.esporte.repository.ModalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("modalidade")
public class ModalidadeController {

    @Autowired
    private ModalidadeRepository repository;

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("modalidades", repository.findAll());
        return "modalidade/lista";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Modalidade modalidade){
        return "modalidade/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Modalidade modalidade, RedirectAttributes redirect){
        repository.save(modalidade);
        redirect.addFlashAttribute("msg","Cadastrado!");
        return "redirect:/modalidade/cadastrar";
    }

}
