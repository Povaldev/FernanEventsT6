package Modelo.Usuario;

import Modelo.Evento.Evento;

public class Organizador extends Usuario { //implements Bloqueable{

    public Evento[] eventos = new Evento[20];
    public int cantEventosCreados;


    public Organizador(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
    }

    private static boolean bloqueo=false;

    public static void setBloqueo(boolean bloqueo) {
        Organizador.bloqueo = bloqueo;
    }

    public static boolean getBloqueo() {
        return bloqueo;
    }

    public static void registraOrganizador(Organizador organizador){
        GestionUsuario.usuarios[GestionUsuario.cantUsuariosRegistrados++] = organizador;
    }

   // @Override
    public static boolean bloquear() {

        return getBloqueo();
    }


//    @Override
//    public void desbloquear() {
//
//    }
}
