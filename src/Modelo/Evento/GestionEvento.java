package Modelo.Evento;

import Vista.Vista;

public class GestionEvento{
    public static Evento[] eventos = new Evento[20];
    private static int cantEventosCreados;


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

}
