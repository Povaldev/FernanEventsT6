package Modelo.Usuario;

import Modelo.Entradas.Entrada;


public class Asistente extends Usuario implements Bloqueable{

    private Entrada[] entradas = new Entrada[20];

    public Asistente(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
    }


    public static void registraAsistente(Asistente asistente){
        GestionUsuario.usuarios[GestionUsuario.cantUsuariosRegistrados++] = asistente;
    }


    @Override
    public void bloquear() {

    }

    @Override
    public void desbloquear() {

    }
}
