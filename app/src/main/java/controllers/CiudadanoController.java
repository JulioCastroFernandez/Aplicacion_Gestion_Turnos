package controllers;

import entities.Ciudadano;
import persistence.ControladorPersistencia;

import java.util.List;

public class CiudadanoController {
    ControladorPersistencia cp = new ControladorPersistencia();

    // METODO para crear un ciudadano
    public void crearCiudadano(String dni, String nombre, String apellido) {
        // Verificamos si los campos están vacíos
        if (dni.isBlank() || nombre.isBlank() || apellido.isBlank()) {
            System.out.println("El dni, nombre y apellidos son obligatorios.");
            return;
        }

        // Verificamos si ya existe un ciudadano con ese DNI
        Ciudadano existe = cp.buscarCiudadanoPorDNI(dni);
        if (existe != null) {
            System.err.println("Ya existe un ciudadano con el DNI: " + dni);
            return;
        }

        // Creamos el ciudadano
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setDni(dni);
        ciudadano.setNombre(nombre);
        ciudadano.setApellido(apellido);
        cp.crearCiudadano(ciudadano);
        System.out.println("Ciudadano creado con éxito: " + ciudadano);
    }

    // METODO para listar los ciudadanos

    public List<Ciudadano> listarCiudadanos() {
        List<Ciudadano> lista = cp.buscarTodosLosCiudadanos();
        if (lista.isEmpty()) {
            System.out.println("No se han encontrado ciudadanos");
        } else {
            System.out.println("Listado: ");
            lista.forEach(System.out::println);
        }
        return lista;
    }
}