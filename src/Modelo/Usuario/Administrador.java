package Modelo.Usuario;

public class Administrador extends Usuario{

    public Administrador(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
    }

    public static void registraAdministrador(Administrador administrador){
        GestionUsuario.usuarios[GestionUsuario.cantUsuariosRegistrados] = administrador;

    }













}
