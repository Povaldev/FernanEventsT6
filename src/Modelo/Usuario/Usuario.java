package Modelo.Usuario;


public class Usuario {

    private int entradasCompradas;
    private String nombre , contrasena, correo;
    private double saldo;
    private boolean bloqueado;
    private int id, asignaID = 0;


    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.saldo = 0;
        this.id = asignaID++;
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

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }

    //    public static compraEntrada(){
//
//    }


}
