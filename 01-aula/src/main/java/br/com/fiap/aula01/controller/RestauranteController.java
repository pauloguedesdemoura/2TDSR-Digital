package br.com.fiap.aula01.controller;

import br.com.fiap.aula01.model.Restaurante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("restaurante")
public class RestauranteController {

    @GetMapping("cadastrar") // URL
    public String abrirFormulario(){
        return "restaurante/form"; //pasta + arquivo html
    }

    @PostMapping("cadastrar")
    public String cadastrar(Restaurante restaurante, Model model){
        System.out.println(restaurante.getNome() + " " + restaurante.getEndereco()
            + " " + restaurante.getFaturamento());

        //mandar uma informação para a página
        model.addAttribute("msg","Cadastrado!");
        model.addAttribute("r", restaurante);

        return "restaurante/sucesso";
    }

}
