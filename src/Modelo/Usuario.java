package Modelo;

public class Usuario {


    private String nombre , contrasena, correo;


    public Usuario(String nombre, String contrasena, String correo) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;

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
}
