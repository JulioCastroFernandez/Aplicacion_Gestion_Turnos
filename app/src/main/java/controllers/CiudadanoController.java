package controllers;

import entities.Ciudadano;
import persistence.ControladorPersistencia;

public class CiudadanoController {
    ControladorPersistencia cp = new ControladorPersistencia();

    // METODO para crear un ciudadano
    public void crearCiudadano(String dni, String nombre, String apellido){
        // Verificamos si los campos están vacíos
        if(dni.isBlank() || nombre.isBlank() || apellido.isBlank()){
            System.out.println("El dni, nombre y apellidos son obligatorios.");
            return;
        }

        // Verificamos si ya existe un ciudadano con ese DNI
        Ciudadano existe = cp.buscarCiudadanoPorDNI(dni);
        if(existe != null){
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
}