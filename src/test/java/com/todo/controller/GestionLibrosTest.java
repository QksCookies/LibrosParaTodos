/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.todo.controller;

import com.todo.model.Libros;
import com.todo.controller.GestionLibros;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author informatica
 */
public class GestionLibrosTest {
    private GestionLibros gestionLibros;
    private Libros libro1;
    private Libros libro2;


    @Test
    void agregarLibro() {
        Libros libro3 = new Libros("The Great Gatsby", "F. Scott Fitzgerald", "Fiction");
        gestionLibros.agregarLibro(libro3);
        List<Libros> libros = gestionLibros.getLibros();
        Assertions.assertEquals(3, libros.size());
        Assertions.assertTrue(libros.contains(libro3));
    }

    @Test
    void mostrarLibrosDisponibles() {
        libro2.setDisponible(false);
        String expectedOutput = "Libros disponibles:\n" +
                "Título: Java: A Beginner's Guide\n" +
                "Autor: Herbert Schildt\n" +
                "Categoría: Programming\n" +
                "\n";
        Assertions.assertEquals(expectedOutput, getOutputString(() -> gestionLibros.mostrarLibrosDisponibles()));
    }

    @Test
    void buscarLibro() {
        Libros encontrado = gestionLibros.buscarLibro("To Kill a Mockingbird");
        Assertions.assertEquals(libro2, encontrado);

        Libros noEncontrado = gestionLibros.buscarLibro("Clean Code");
        Assertions.assertNull(noEncontrado);
    }

    private String getOutputString(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream oldPrintStream = System.out;
        System.setOut(printStream);
        runnable.run();
        System.out.flush();
        System.setOut(oldPrintStream);
        return outputStream.toString();
    }
}
