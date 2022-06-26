package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        return "redirect:allPancakes";
    }
    //-------------------------------------------------------------------

    //------------------------------SEARCH PANCAKE BY NAME-------------------------

    @GetMapping("/searchPancake")
    public String getPancakeByName(Model model) {
        model.addAttribute("searchPancake", new Pancake());
        return "searchPancake";
    }

    @PostMapping("/searchPancake")
    public String displayPancakeByName(@ModelAttribute Pancake pancake, Model model) {
        model.addAttribute("searchPancake", pancakeRepository.findByName(pancake.getName()));
        return "displayPancake";
    }
}
