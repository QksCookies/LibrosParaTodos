/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todo.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class Clientes {
    private String nombre;
    private List<Libros> librosReservados;

    public Clientes(String nombre) {
        this.nombre = nombre;
        this.librosReservados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Libros> getLibrosReservados() {
        return librosReservados;
    }

    public void reservarLibro(Libros libro) {
        if (libro.isDisponible()) {
            libro.setDisponible(false);
            librosReservados.add(libro);
            System.out.println("El libro \"" + libro.getTitulo() + "\" ha sido reservado por " + nombre + ".");
        } else {
            System.out.println("Lo siento, el libro \"" + libro.getTitulo() + "\" no está disponible actualmente.");
        }
    }

    public void devolverLibro(Libros libro) {
        if (librosReservados.contains(libro)) {
            libro.setDisponible(true);
            librosReservados.remove(libro);
            System.out.println("El libro \"" + libro.getTitulo() + "\" ha sido devuelto por " + nombre + ".");
        } else {
            System.out.println("No se puede devolver el libro \"" + libro.getTitulo() + "\" porque no fue reservado por " + nombre + ".");
        }
    }
}
