package Modelo.Usuario;

import Modelo.Entradas.Entrada;

public class Usuario {
    private Entrada[] entradas = new Entrada[20];
    private int entradasCompradas;
    private String nombre , contrasena, correo;
    private double saldo;
    private boolean bloqueado;


    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.saldo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getCorreo() {
        return correo;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public static compraEntrada(){

    }


}
