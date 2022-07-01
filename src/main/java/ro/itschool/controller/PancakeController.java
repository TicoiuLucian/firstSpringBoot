package ro.itschool.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.itschool.entity.Pancake;
import ro.itschool.repository.PancakeRepository;

import java.util.List;

@Log4j2
@Controller
public class PancakeController {

    @Autowired
    private PancakeRepository pancakeRepository;


    //---------------------------------- GET all pancakes ------------------------------
    @GetMapping("/pancakes")
    public String getAllPancakes(Model model) {
        log.info("Getting all pancakes...");
        model.addAttribute("pancakes", pancakeRepository.findAll());
        return "allPancakes";
    }
    //-------------------------------------------------------------------


    //------------------------------POST PANCAKE-------------------------
    //Aici intra cand se incarca pagina si creeaza un Pancake gol
    //Daca n-ar fi pancake gol, n-am avea unde sa ne salvam valorile
    @GetMapping("/savePancake")
    public String greetingForm(Model model) {
        log.info("Creating empty pancake...");
        model.addAttribute("pancakeObject", new Pancake());
        log.info("Empty pancake created.");
        return "savePancake";
    }

    //Cand dam submit in html, aplicatia intra aici
    //Pancake-ul vine populat din html
    @PostMapping("/savePancake")
    public String greetingSubmit(@ModelAttribute Pancake pancake, Model model) {
        log.info("Submitting pancake...");
        model.addAttribute("pancakeObject", pancake);
        pancakeRepository.save(pancake);
        log.info("Pancake was created");
        return "redirect:/pancakes";

    }

    //----------------------------Update---------------------------------------//


    @GetMapping("/updatePancake/{id}")
    public String getPancakeById(@PathVariable Integer id, Model model) {
        log.info("Updating pancake with id : " + id);
        if (pancakeRepository.findById(id).isPresent()) {
            model.addAttribute("pancake", pancakeRepository.findById(id).get());
            return "updatePancake";
        }
        log.info("Pancake was updated.");
        return ("Pancake not found for this id : " + id);
    }


    @RequestMapping(path = "/delete/{id}")
    public String deletePancakeById(Model model, @PathVariable("id") Integer id) throws Exception {
        log.info("Deleting pancake with id: " + id + ".");
        pancakeRepository.deleteById(id);
        log.info("Pancake was deleted.");
        return "redirect:/pancakes";
    }





}
