package com.spring.loteria.Controller;

import com.spring.loteria.Model.Aposta;
import com.spring.loteria.Service.LoteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ApostaController {

    @Autowired
    LoteriaService loteriaService;

    @RequestMapping(value = "/apostas", method = RequestMethod.GET)
    public ModelAndView getApostas(Aposta aposta){
        ModelAndView mv = new ModelAndView("apostas");
        List<Aposta> apostas = loteriaService.findAll();
        mv.addObject("apostas", apostas);
        return mv;
    }

    @RequestMapping(value = "/apostas", method = RequestMethod.POST)
    public String saveAposta(@Valid Aposta aposta, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            //attributes.addFlashAttribute("mensagem", "Email inválido. Preencha novamente");
            return "redirect:/apostas";
        }
        aposta.setDataAposta(LocalDate.now());
        aposta.setAposta();
        loteriaService.save(aposta);
        return "redirect:/apostas?modal=sim";
    }

//    @RequestMapping(value = "/apostafeita", method = RequestMethod.GET)
//    public ModelAndView getApostafeita(Aposta aposta){
//        ModelAndView mv = new ModelAndView("apostas");
//        List<Aposta> apostafeita = loteriaService.findAll();
//        mv.addObject("apostafeita", apostafeita);
//        return mv;
//    }
//
//    @RequestMapping(value = "/apostafeita", method = RequestMethod.POST)
//    public ModelAndView postApostafeita(Aposta aposta){
//        ModelAndView mv = new ModelAndView("apostafeita");
//        List<Aposta> apostafeita = loteriaService.findAll();
//        mv.addObject("apostafeita", apostafeita);
//        return mv;
//    }

    //    @RequestMapping(value = "/teste/{email2}", method = RequestMethod.GET)
//    public ModelAndView getTeste(@PathVariable("email") String email, Aposta aposta){
//        ModelAndView mv = new ModelAndView("teste");
//        String email2 = aposta.getEmail();
//        List<Aposta> apostasEmail = loteriaService.findByemail(email2);
//        mv.addObject("teste", apostasEmail);
//        return mv;
//    }


    //    @RequestMapping(value = "/apostas/{email}", method= RequestMethod.GET)
//    public ModelAndView getApostas(@PathVariable("email") String email){
//        ModelAndView mv = new ModelAndView("apostas");
//        List<Aposta> apostas = loteriaService.findByemail(email);
//        mv.addObject("apostas", apostas);
//        return mv;
//    }

}