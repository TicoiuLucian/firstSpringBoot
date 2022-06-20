package ro.itschool.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Pancake;
import ro.itschool.repository.PancakeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
public class PancakeController {

    @Autowired
    private PancakeRepository pancakeRepository;

    @GetMapping(value = "/pancakes")
    public List<Pancake> getPancake() {
        return pancakeRepository.findAll();
    }

    @PostMapping(value = "/pancakes")
    public Pancake savePancake(@RequestBody Pancake pancake) {
        return pancakeRepository.save(pancake);
    }

    @DeleteMapping(value = "/pancakes/{id}")
    public String deletePancake(@PathVariable Integer id) {
        Optional<Pancake> pancake = pancakeRepository.findById(id);
        if (pancake.isPresent()) {
            pancakeRepository.delete(pancake.get());
            return String.format("Pancake with id %d was deleted", id);
        } else
            return String.format("Pancake with id %d not found", id);
    }
}
