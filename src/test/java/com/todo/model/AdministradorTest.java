/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.todo.model;

import com.todo.controller.GestionLibros;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author informatica
 */
public class AdministradorTest {
private GestionLibros gestionLibros;
    private Administrador administrador;
    private Libros libro1;
    private Libros libro2;

    @BeforeEach
    void setUp() {
        gestionLibros = new GestionLibros();
        libro1 = new Libros("Java: A Beginner's Guide", "Herbert Schildt", "Programming");
        libro2 = new Libros("To Kill a Mockingbird", "Harper Lee", "Fiction");
        gestionLibros.agregarLibro(libro1);
        gestionLibros.agregarLibro(libro2);
        administrador = new Administrador(gestionLibros);
    }

    @Test
    void actualizarDisponibilidad() {
        administrador.actualizarDisponibilidad(libro1, false);
        Assertions.assertFalse(libro1.isDisponible());
    }
    
    @Test
    void agregarLibro() {
        Libros libro3 = new Libros("The Great Gatsby", "F. Scott Fitzgerald", "Fiction");
        administrador.agregarLibro(libro3);
        List<Libros> libros = gestionLibros.getLibros();
        Assertions.assertEquals(3, libros.size());
        Assertions.assertTrue(libros.contains(libro3));
    }
    
    @Test
    void eliminarLibro() {
        administrador.eliminarLibro(libro1);
        List<Libros> libros = gestionLibros.getLibros();
        Assertions.assertEquals(1, libros.size());
        Assertions.assertFalse(libros.contains(libro1));
        Assertions.assertTrue(libros.contains(libro2));

        // Intentar eliminar un libro no existente
        Libros libroNoExistente = new Libros("Clean Code", "Robert C. Martin", "Programming");
        administrador.eliminarLibro(libroNoExistente);
        Assertions.assertEquals(1, libros.size());
        Assertions.assertFalse(libros.contains(libroNoExistente));
    }

    @Test
    void registrarVenta() {
        administrador.registrarVenta(libro1);
        administrador.registrarVenta(libro1);
        administrador.registrarVenta(libro2);
        Map<Libros, Integer> ventas = administrador.getVentas();
        Assertions.assertEquals(2, ventas.get(libro1));
        Assertions.assertEquals(1, ventas.get(libro2));
        // Verificar que no se pueda registrar la venta de un libro no disponible
        libro1.setDisponible(false);
        administrador.registrarVenta(libro1);
        Assertions.assertEquals(2, ventas.get(libro1));
    }

    @Test
    void generarInformeVentas() {
        administrador.registrarVenta(libro1);
        administrador.registrarVenta(libro1);
        administrador.registrarVenta(libro2);
        String expectedOutput = "Informe de ventas:\n" +
                "Título: Java: A Beginner's Guide\n" +
                "Autor: Herbert Schildt\n" +
                "Categoría: Programming\n" +
                "Cantidad de ventas: 2\n" +
                "\n" +
                "Título: To Kill a Mockingbird\n" +
                "Autor: Harper Lee\n" +
                "Categoría: Fiction\n" +
                "Cantidad de ventas: 1\n" +
                "\n";
        Assertions.assertEquals(expectedOutput, getOutputString(() -> administrador.generarInformeVentas()));
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
