package Modelo.Usuario;

public class Organizador extends Usuario implements Bloqueable{


    public Organizador(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
    }

    public static void registraOrganizador(Organizador organizador){
        GestionUsuario.usuarios[GestionUsuario.cantUsuariosRegistrados] = organizador;
    }

    @Override
    public void bloquear() {

    }

    @Override
    public void desbloquear() {

    }
}
