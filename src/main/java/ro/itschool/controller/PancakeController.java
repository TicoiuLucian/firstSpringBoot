package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.itschool.entity.Pancake;
import ro.itschool.repository.PancakeRepository;


@Controller
public class PancakeController {

    @Autowired
    private PancakeRepository pancakeRepository;


    //---------------------------------- GET all pancakes ------------------------------
    @GetMapping("/pancakes")
    public String getAllPancakes(Model model) {
        model.addAttribute("pancakes", pancakeRepository.findAll());
        return "allPancakes";
    }
    //-------------------------------------------------------------------


    //------------------------------POST PANCAKE-------------------------
    //Aici intra cand se incarca pagina si creeaza un Pancake gol
    //Daca n-ar fi pancake gol, n-am avea unde sa ne salvam valorile
    @GetMapping("/savePancake")
    public String greetingForm(Model model) {
        model.addAttribute("pancakeObject", new Pancake());
        return "savePancake";
    }

    //Cand dam submit in html, aplicatia intra aici
    //Pancake-ul vine populat din html
    @PostMapping("/savePancake")
    public String greetingSubmit(@ModelAttribute Pancake pancake, Model model) {
        model.addAttribute("pancakeObject", pancake);
        pancakeRepository.save(pancake);
        return "redirect:/pancakes";
    }

    //----------------------------Update---------------------------------------//



    @GetMapping("/updatePancake/{id}")
    public String getPancakeById(@PathVariable Integer id, Model model) {
        if (pancakeRepository.findById(id).isPresent()) {
            model.addAttribute("pancake", pancakeRepository.findById(id).get());
            return "updatePancake";
        }
        return ("Pancake not found for this id : " + id);
    }



    @RequestMapping(path = "/delete/{id}")
    public String deletePancakeById(Model model, @PathVariable("id") Integer id)
            throws Exception
    {
        pancakeRepository.deleteById(id);
        return "redirect:/pancakes";
    }
}
