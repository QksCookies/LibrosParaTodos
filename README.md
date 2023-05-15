# LibrosParaTodos
Parcial Final Análisis y Diseño de Sistemas.

Este es un sistema de gestión de libros que permite administrar una colección de libros, registrar ventas, reservar libros y generar informes de ventas. El sistema está implementado en Java y consta de varias clases que interactúan entre sí.

Clases
GestionLibros
La clase GestionLibros es responsable de gestionar la colección de libros. Tiene los siguientes métodos:

GestionLibros(): Constructor de la clase que inicializa la lista de libros.
agregarLibro(Libros libro): Agrega un libro a la colección.
mostrarLibrosDisponibles(): Muestra los libros disponibles en la colección.
buscarLibro(String titulo): Busca un libro por título y devuelve el objeto Libros correspondiente.
eliminarLibro(Libros libro): Elimina un libro de la colección.
getLibros(): Devuelve la lista de libros.
Administrador
La clase Administrador se encarga de realizar tareas de administración de libros y ventas. Tiene los siguientes métodos:

Administrador(GestionLibros gestionLibros): Constructor de la clase que recibe un objeto GestionLibros para gestionar la colección de libros.
actualizarDisponibilidad(Libros libro, boolean disponible): Actualiza la disponibilidad de un libro.
agregarLibro(Libros libro): Agrega un libro a la colección a través de GestionLibros.
eliminarLibro(Libros libro): Elimina un libro de la colección si no está disponible o no ha sido vendido.
registrarVenta(Libros libro): Registra una venta de un libro incrementando su contador de ventas.

![Ejemplo genéricos 1 drawio](https://github.com/QksCookies/LibrosParaTodos/assets/128483888/9e7f1fad-47a2-4c1e-bff0-4bcbcf07ba27)
