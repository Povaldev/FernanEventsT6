package Modelo.Usuario;

import Modelo.Entradas.Entrada;

import static Modelo.Evento.GestionEvento.eventos;


public class Asistente extends Usuario implements Bloqueable{

    public Entrada[] entradas = new Entrada[20];
    public int entradasCompradas;

    public Asistente(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
        this.entradasCompradas = 0;
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

    public void compraEntrada(int eventoID, int tipoEntrada){
        this.entradas[entradasCompradas] = eventos[eventoID].tipoEntradas[tipoEntrada];;
    }
}
