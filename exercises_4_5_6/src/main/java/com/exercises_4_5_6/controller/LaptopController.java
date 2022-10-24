package com.exercises_4_5_6.controller;

import com.exercises_4_5_6.entities.Laptop;
import com.exercises_4_5_6.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private final LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/laptops")
    public List<Laptop> findAll()  {

        return laptopRepository.findAll();
    }

    @GetMapping("/laptops/{id}")
    public ResponseEntity<Laptop> findOneById( @PathVariable Long id) {
        Optional<Laptop> bookOptional = laptopRepository.findById(id);
        return bookOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
        if(laptop.getId() != null) {
            log.warn("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            log.warn("Triying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("Triying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {
        if (!laptopRepository.existsById(id)) {
            log.warn("Triying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/laptops")
    public ResponseEntity<Laptop> deleteAll() {
        log.info("REST Request deleting all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
