package com.exercises_4_5_6.infrastructure;

import com.exercises_4_5_6.model.Laptop;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/laptops")
    public List<Laptop> findAll()  {
        return laptopRepository.findAll();
    }

    @PostMapping("/laptop")
    public void createLaptop( @RequestBody Laptop laptop) {
        laptopRepository.save(laptop);
    }
}
