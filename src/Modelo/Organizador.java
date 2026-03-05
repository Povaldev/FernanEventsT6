package Modelo;

public class Organizador extends Usuario {

    private double cartera;

    public Organizador(String nombre, String contrasena, String correo, double cartera) {
        super(nombre, contrasena, correo);
        this.cartera = cartera;
    }
}
