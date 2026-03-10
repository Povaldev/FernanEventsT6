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
            Vista.muestraMensaje(GestionEvento.eventos[i].toString() + "\n");
        }
    }

    public static void creaEvento(Evento evento){
        eventos[getCantEventosCreados()] = evento;
    }

    public static void eliminaEvento(int idEvento){
        GestionEvento.eventos[idEvento] = GestionEvento.eventos[GestionEvento.getCantEventosCreados()];
        GestionEvento.eventos[GestionEvento.getCantEventosCreados()] = null;
    }


    /// Devuelve el id de un evento a través del nombre del evento. Además se puede comprobar la existencia de un evento,
    /// en el caso de que no exista la función retorna -1
    public static int devuelveIDPorNombre(String nombreEvento){
        for (int i = 0; i < cantEventosCreados; i++) {
            if (eventos[i].getNombre().equals(nombreEvento)) return eventos[i].getIdEvento();
        }
        return -1;
    }


    /// Función que retorna la posicion del array donde el ID almacenado coincide con el se le pasa.
    /// En el caso de no coincidir, retorna 0
    public static int devuelvePosicionPorID(int eventoID){
        for (int i = 0; i < cantEventosCreados; i++) {
            if (eventos[i].getIdEvento() == eventoID) return i;
        }
        return -1;
    }



}
