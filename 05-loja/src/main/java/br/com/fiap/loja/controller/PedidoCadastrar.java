package br.com.fiap.loja.controller;

import br.com.fiap.loja.model.Cliente;
import br.com.fiap.loja.model.Pedido;
import br.com.fiap.loja.repository.ClienteRepository;
import br.com.fiap.loja.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoCadastrar {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("cadastrar/{id}")
    public String cadastrar(@PathVariable("id") int codigo, Pedido pedido, Model model){
        Cliente cliente = clienteRepository.findById(codigo).get(); //pesquisa o cliente pelo id
        pedido.setCliente(cliente); //seta o cliente do pedido
        model.addAttribute("cliente", cliente); //envia o cliente para a tela
        return "pedido/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid Pedido pedido, BindingResult result, RedirectAttributes redirect){
        if (result.hasErrors()){
            return "pedido/form";
        }
        pedidoRepository.save(pedido);
        redirect.addFlashAttribute("msg", "Cadastrado!");
        return "redirect:/pedido/cadastrar";
    }

}
