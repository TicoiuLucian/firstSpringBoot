package ro.itschool.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Pancake;
import ro.itschool.repository.PancakeRepository;

import java.util.List;
import java.util.Optional;

// @RestController
@Log4j2
public class OldPancakeController {

    @Autowired
    private PancakeRepository pancakeRepository;


    @GetMapping(value = "/pancakes")
    @ExceptionHandler(Exception.class)
    public ResponseEntity<List<Pancake>> getPancake() {
        final List<Pancake> pancakeList = pancakeRepository.findAll();
        return new ResponseEntity<>(pancakeList, HttpStatus.OK);
//        return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);
//        return ResponseEntity.status(HttpStatus.FORBIDDEN)
//                .body("Error Message");
    }


    @GetMapping(value = "pancakes/{id}")
    public ResponseEntity getPancakeById(@PathVariable Integer id) {
        Optional<Pancake> pancake = pancakeRepository.findById(id);
        if (pancake.isPresent())
            return new ResponseEntity(pancake.get(), HttpStatus.OK);
        else
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("Pancake with id %d was not found", id));
    }


    @PostMapping(value = "/pancakes")
    public ResponseEntity<Pancake> savePancake(@RequestBody Pancake pancake) {
        return new ResponseEntity<>(pancakeRepository.save(pancake), HttpStatus.OK);
    }


    @DeleteMapping(value = "/pancakes/{id}")
    public ResponseEntity deletePancake(@PathVariable Integer id) {
        Optional<Pancake> pancake = pancakeRepository.findById(id);
        if (pancake.isPresent()) {
            pancakeRepository.delete(pancake.get());
            return new ResponseEntity("", HttpStatus.OK);
        } else
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("Pancake with id %d was not found", id));
    }

}
