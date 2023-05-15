/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todo.controller;

import com.todo.model.Libros;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author informatica
 */
public class GestionLibros {
    private List<Libros> libros;

    public GestionLibros() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libros libro) {
        libros.add(libro);
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles:");
        for (Libros libro : libros) {
            if (libro.isDisponible()) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("Categoría: " + libro.getCategoria());
                System.out.println();
            }
        }
    }

    public Libros buscarLibro(String titulo) {
        for (Libros libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
    
     public void eliminarLibro(Libros libro) {
        Iterator<Libros> iterator = libros.iterator();
        while (iterator.hasNext()) {
            Libros currentLibro = iterator.next();
            if (currentLibro.equals(libro)) {
                iterator.remove();
                System.out.println("El libro \"" + libro.getTitulo() + "\" ha sido eliminado del sistema.");
                return;
            }
        }
        System.out.println("El libro \"" + libro.getTitulo() + "\" no existe en el sistema.");
    }

    public List<Libros> getLibros() {
        return libros;
    }
}
