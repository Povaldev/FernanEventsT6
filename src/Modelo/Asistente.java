package Modelo;

public class Asistente extends Usuario {

    private double cartera;

    public Asistente(String nombre, String contrasena, String correo, double cartera) {
        super(nombre, contrasena, correo);
        this.cartera = cartera;
    }
}
