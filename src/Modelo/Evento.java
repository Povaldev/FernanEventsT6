package Modelo;

import Modelo.Entradas.Entrada;
import Vista.Vista;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    public static Evento[] eventos = new Evento[20];

    private static int generaIDsEventos = 0, cantEventosCreados = 0;
    private String nombre, descripcion, categoria;
    private LocalDate fecha;
    private LocalTime hora;
    private int aforo, numInscritos, idEvento;
    private Entrada entrada;



    public Evento(String nombre, String descripcion, String categoria, LocalDate fecha, LocalTime hora, int aforo){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.hora = hora;
        this.aforo = aforo;
        this.idEvento = generaIDsEventos++;
        cantEventosCreados++;
    }


    public static int getGeneraIDsEventos() {
        return generaIDsEventos;
    }

    public static int getCantEventosCreados() {
        return cantEventosCreados;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public int getAforo() {
        return aforo;
    }

    public int getNumInscritos() {
        return numInscritos;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public static void setGeneraIDsEventos(int generaIDsEventos) {
        Evento.generaIDsEventos = generaIDsEventos;
    }

    public static void setCantEventosCreados(int cantEventosCreados) {
        Evento.cantEventosCreados = cantEventosCreados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public void setNumInscritos(int numInscritos) {
        this.numInscritos = numInscritos;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }


    public static Evento buscaEventoPorID(int idEvento){
        for (int i = 0; i < getCantEventosCreados(); i++) {
            if (eventos[i].getIdEvento()==idEvento) return eventos[i];
        }
        return null;
    }

    public static int buscaPosicionPorID(int idEvento){
        for (int i = 0; i < getCantEventosCreados(); i++) {
            if (eventos[i].getIdEvento() == idEvento) return i;
        }
        return -1;
    }


    public String vistaDetalladaEvento() {
        return Vista.vistaDetalladaEvento((double) (getNumInscritos() * 100) / getAforo());
    }

    public void modificaEvento(String nombre, String descripcion, String categoria, LocalDate fecha, LocalTime hora, int aforo){
        setNombre(nombre);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setFecha(fecha);
        setHora(hora);
        setAforo(aforo);
        Vista.muestraMensaje(nombre + " ha sido modificado con éxito");
    }

    public static void eliminaEvento(int idEvento){
        eventos[idEvento] = eventos[getCantEventosCreados()];
        eventos[getCantEventosCreados()] = null;
    }


    public void muestraEventos(){
        for (int i = 0; i < getCantEventosCreados(); i++) {
            Vista.muestraMensaje(eventos[i].toString());
        }
    }



    public String toString() {
        return "****(ID: " + this.idEvento + "****\n" +
                "Nombre: " + this.nombre + "\n" +
                "Descripcion: " + this.descripcion + "\n" +
                "Categoría: " + this.categoria + "\n" +
                "Fecha y hora: " + this.fecha + this.hora + "\n" +
                "Aforo: " + this.aforo + "\n" +
                "Nombre: " + this.nombre + "\n" +
                vistaDetalladaEvento() + "\n" +

                ;
    }
}
