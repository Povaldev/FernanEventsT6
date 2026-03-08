package Modelo.Usuario;

import java.util.Scanner;

public class Asistente extends Usuario implements Bloqueable{

    public Asistente(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
    }


    public static void registraAsistente(Asistente asistente){
        GestionUsuario.usuarios[GestionUsuario.cantUsuariosRegistrados] = asistente;
    }


    @Override
    public void bloquear() {

    }

    @Override
    public void desbloquear() {

    }
}
