package Modelo.Evento;

import Vista.Vista;

public class GestionEvento{
    public static Evento[] eventos = new Evento[20];
    public static int cantEventosCreados;


    public static int getCantEventosCreados() {
        return cantEventosCreados;
    }

    public static void setCantEventosCreados(int cantEventosCreados){
        GestionEvento.cantEventosCreados = cantEventosCreados;
    }

    public static void muestraEventos(){
        for (int i = 0; i < getCantEventosCreados(); i++) {
            Vista.muestraMensaje(GestionEvento.eventos[i].toString());
        }
    }

    public static void creaEvento(Evento evento){
        eventos[getCantEventosCreados()] = evento;
    }

    public static void eliminaEvento(int idEvento){
        GestionEvento.eventos[idEvento] = GestionEvento.eventos[GestionEvento.getCantEventosCreados()];
        GestionEvento.eventos[GestionEvento.getCantEventosCreados()] = null;
    }


}
