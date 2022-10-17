package com.exercises_4_5_6.infrastructure;

import com.exercises_4_5_6.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository <Laptop, Integer> {
}
