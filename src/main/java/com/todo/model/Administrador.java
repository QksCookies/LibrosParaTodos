/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todo.model;

import com.todo.controller.GestionLibros;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author informatica
 */
public class Administrador {
    private GestionLibros gestionLibros;
    private Map<Libros, Integer> ventas;

    public Administrador(GestionLibros gestionLibros) {
        this.gestionLibros = gestionLibros;
        this.ventas = new HashMap<>();
    }

    public void actualizarDisponibilidad(Libros libro, boolean disponible) {
        libro.setDisponible(disponible);
    }

    public void agregarLibro(Libros libro) {
        gestionLibros.agregarLibro(libro);
    }

    public void eliminarLibro(Libros libro) {
        if (!libro.isDisponible() || !ventas.containsKey(libro)) {
            gestionLibros.eliminarLibro(libro);
        } else {
            System.out.println("No se puede eliminar el libro \"" + libro.getTitulo() + "\" porque está disponible o ha sido vendido.");
        }
    }

    public void registrarVenta(Libros libro) {
        if (libro.isDisponible()) {
            int cantidadVentas = ventas.getOrDefault(libro, 0);
            ventas.put(libro, cantidadVentas + 1);
        } else {
            System.out.println("No se puede registrar la venta del libro \"" + libro.getTitulo() + "\" porque no está disponible.");
        }
    }

    public void generarInformeVentas() {
        System.out.println("Informe de ventas:");
        for (Map.Entry<Libros, Integer> entry : ventas.entrySet()) {
            Libros libro = entry.getKey();
            int cantidadVentas = entry.getValue();
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Categoría: " + libro.getCategoria());
            System.out.println("Cantidad de ventas: " + cantidadVentas);
            System.out.println();
        }
    }

    Map<Libros, Integer> getVentas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
