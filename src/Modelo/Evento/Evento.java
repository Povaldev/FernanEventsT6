package Modelo.Evento;

import Controlador.Controlador;
import Modelo.Entradas.Entrada;
import Vista.Vista;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {

    public Entrada[] tipoEntradas = new Entrada[3];
    private static int generaIDsEventos = 0;
    private String nombre, descripcion, categoria;
    private LocalDate fecha;
    private LocalTime hora;
    private int aforo, numInscritos, idEvento, cantEntradas;



    public Evento(String nombre, String descripcion, String categoria, LocalDate fecha, LocalTime hora, int aforo){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.hora = hora;
        this.aforo = aforo;
        this.idEvento = generaIDsEventos++;
        Controlador.creaEntrada(this.getIdEvento());
        GestionEvento.setCantEventosCreados(++GestionEvento.cantEventosCreados);
    }

    public static void enlazaEntradaAEvento(Entrada entrada, int idEvento){
        int posicion = buscaPosicionPorID(idEvento);
        // Del objeto almacenado en el array de objetos en "Gestión de objetos" se le asigna a su array de eventos "tipoEntradas" la entrada que se le pasa al metodo
        GestionEvento.eventos[posicion].tipoEntradas[GestionEvento.eventos[posicion].getCantEntradas()] = entrada;
    }

    public static int getGeneraIDsEventos() {
        return generaIDsEventos;
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


    public Entrada[] getEntrada() {
        return tipoEntradas;
    }

    public int getCantEntradas() {
        return cantEntradas;
    }

    public static void setGeneraIDsEventos(int generaIDsEventos) {
        Evento.generaIDsEventos = generaIDsEventos;
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

    public void setCantEntradas(int cantEntradas) {
        this.cantEntradas = cantEntradas;
    }

    public static Evento buscaEventoPorID(int idEvento){
        for (int i = 0; i < GestionEvento.getCantEventosCreados(); i++) {
            if (GestionEvento.eventos[i].getIdEvento()==idEvento) return GestionEvento.eventos[i];
        }
        return null;
    }

    public static int buscaPosicionPorID(int idEvento){
        for (int i = 0; i < GestionEvento.getCantEventosCreados(); i++) {
            if (GestionEvento.eventos[i].getIdEvento() == idEvento) return i;
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








    public String toString() {
        return "****(ID: " + this.idEvento + "****\n" +
                "Nombre: " + this.nombre + "\n" +
                "Descripcion: " + this.descripcion + "\n" +
                "Categoría: " + this.categoria + "\n" +
                "Fecha "  + this.fecha + " Hora: " + this.hora + "\n" +
                "Aforo máximo: " + this.aforo + "\n" +
                vistaDetalladaEvento() + "\n" +
                "*********************************";
    }
}
