package Modelo.Entradas;

import Modelo.Evento.Evento;
import Modelo.Evento.GestionEvento;
import Modelo.Usuario.Asistente;

public class Entrada implements InterfazEntrada {
    private static int cantidadEntradasCreadas;

    private Asistente asistente;
    private int EventoID, stock;
    private double precio;
    private String descripcion;
    private TipoEntrada tipoEntrada;

    public Entrada(TipoEntrada tipoEntrada, double precio, String descripcion, int stock, int EventoID){
        this.tipoEntrada = tipoEntrada;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.EventoID = EventoID;
        this.asistente = null;
    }


    public boolean compraEntrada(){
        if (getStock()>0){
            this.stock--;
            return true;
        }
        return false;
    }

//    public static void creaEntrada(Entrada entrada){
//        GestionEvento.
//    }



    public static int getCantidadEntradasCreadas() {
        return cantidadEntradasCreadas;
    }

    public int getEventoID() {
        return EventoID;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public static void setCantidadEntradasCreadas(int cantidadEntradasCreadas) {
        Entrada.cantidadEntradasCreadas = cantidadEntradasCreadas;
    }

    public void setEventoID(int eventoID) {
        EventoID = eventoID;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    @Override
    public void aumentaCantidad() {

    }

    @Override
    public void disminuyeCantidad() {

    }
}