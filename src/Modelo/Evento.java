package Modelo;

import Modelo.Entradas.Entrada;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Vista.Vista.*;

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


    public void creaEvento(){

    }
}
