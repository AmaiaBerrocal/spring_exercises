package com.exercises_4_5_6.controller;

import com.exercises_4_5_6.repository.LaptopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LaptopControllerTest {
    LaptopController sut;
    LaptopRepository lr;

    @BeforeEach
    void setUp() {
        lr = mock(LaptopRepository.class);
        sut = new LaptopController(lr);
    }

    @Test
    //void findAll() {}
    void should_return_a_list_of_laptops() {
        //given
        //when
        sut.findAll();
        //then
        verify(lr).findAll();
    }

    @Test
    void findOneById() {

    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }
}