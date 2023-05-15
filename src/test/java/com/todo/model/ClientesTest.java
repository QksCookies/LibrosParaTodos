/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.todo.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author informatica
 */
public class ClientesTest {
    private Clientes cliente;
    private Libros libro1;
    private Libros libro2;

    @BeforeEach
    void setUp() {
        cliente = new Clientes("John Doe");
        libro1 = new Libros("Java: A Beginner's Guide", "Herbert Schildt", "Programming");
        libro2 = new Libros("To Kill a Mockingbird", "Harper Lee", "Fiction");
    }

    @Test
    void reservarLibro() {
        cliente.reservarLibro(libro1);
        List<Libros> librosReservados = cliente.getLibrosReservados();
        Assertions.assertEquals(1, librosReservados.size());
        Assertions.assertTrue(librosReservados.contains(libro1));
        Assertions.assertFalse(libro1.isDisponible());
    }

    @Test
    void reservarLibroNoDisponible() {
        libro2.setDisponible(false);
        cliente.reservarLibro(libro2);
        List<Libros> librosReservados = cliente.getLibrosReservados();
        Assertions.assertEquals(0, librosReservados.size());
        Assertions.assertFalse(librosReservados.contains(libro2));
        Assertions.assertFalse(libro2.isDisponible());
    }

    @Test
    void devolverLibro() {
        cliente.reservarLibro(libro1);
        cliente.devolverLibro(libro1);
        List<Libros> librosReservados = cliente.getLibrosReservados();
        Assertions.assertEquals(0, librosReservados.size());
        Assertions.assertFalse(librosReservados.contains(libro1));
        Assertions.assertTrue(libro1.isDisponible());
    }

    @Test
    void devolverLibroNoReservado() {
        cliente.devolverLibro(libro1);
        List<Libros> librosReservados = cliente.getLibrosReservados();
        Assertions.assertEquals(0, librosReservados.size());
        Assertions.assertFalse(librosReservados.contains(libro1));
        Assertions.assertTrue(libro1.isDisponible());
    }
}
