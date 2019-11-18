package br.edu.ifal.formulario_pweb2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class Controlador{

    UsuarioRepositorio usuarioRepo;
    Usuario usuario = new Usuario();


    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }

    @RequestMapping("/formulairo")
    public ModelAndView formulario(Usuario usuario){
        ModelAndView retorno = new ModelAndView("formulario.html");
        retorno.addObject("usuario", usuario);
        return retorno;
    }

    @RequestMapping("/novoCadastro")
    public ModelAndView novoCadastro(Usuario usuario, RedirectAttributes redirect) {
        usuarioRepo.save(usuario);
        ModelAndView retorno = new ModelAndView("redirect:/lista.html");
        redirect.addFlashAttribute("mensagem" , usuario.getNome() + "cadastrado com sucesso ");

        return retorno;
    }

}