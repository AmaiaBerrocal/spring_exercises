package com.exercises;

import org.springframework.stereotype.Component;

@Component
public class Saludo {
    public void imprimirSaludo() {
        System.out.println("¡Hola!");
    }
}
