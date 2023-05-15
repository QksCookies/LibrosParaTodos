/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todo.view;

import com.todo.controller.GestionLibros;
import com.todo.model.Administrador;
import com.todo.model.Libros;
import java.util.Scanner;

/**
 *
 * @author informatica
 */
public class LlevarLibro {
    public static void main(String[] args) {
        GestionLibros gestionLibros = new GestionLibros();
        Libros calculo = new Libros("CALCULO MULTIVARIABLE", "GRACIELA", "MATEMATICAS");
        Libros anillos = new Libros("EL SEÑOR DE LOS ANILLOS", "J.R.R TOLKIEN", "FICCION Y AVENTURA");
        Libros hobbit = new Libros("EL HOBBIT", "J.R.R TOLKIEN", "FICCION Y AVENTURA");
        gestionLibros.agregarLibro(calculo);
        gestionLibros.agregarLibro(anillos);
        gestionLibros.agregarLibro(hobbit);

        Administrador administrador = new Administrador(gestionLibros);

        // Actualizar disponibilidad de un libro
        administrador.actualizarDisponibilidad(anillos, false);

        // Agregar un nuevo libro
        Libros libro4 = new Libros("Clean Code", "Robert C. Martin", "Programming");
        administrador.agregarLibro(libro4);

        // Eliminar un libro
        administrador.eliminarLibro(hobbit);

        // Mostrar libros disponibles
        gestionLibros.mostrarLibrosDisponibles();

        // Registrar ventas
        administrador.registrarVenta(calculo);
        administrador.registrarVenta(calculo);
        administrador.registrarVenta(anillos);

        // Generar informe de ventas
        administrador.generarInformeVentas();

        // Buscar un libro
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro a buscar: ");
        String tituloBuscado = scanner.nextLine();
        Libros libroBuscado = gestionLibros.buscarLibro(tituloBuscado);
        if (libroBuscado != null) {
            System.out.println("El libro \"" + libroBuscado.getTitulo() + "\" está disponible en la librería.");
        } else {
            System.out.println("El libro \"" + tituloBuscado + "\" no se encuentra en la librería.");
        }
    }
}
