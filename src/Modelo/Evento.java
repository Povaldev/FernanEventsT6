package Modelo;

import Modelo.Entradas.Entrada;

import java.time.LocalDate;

public class Evento {
    public static Evento[] eventos;
    private String nombre, Descripcion, categoria;
    private LocalDate fecha, hora;
    private int aforo, numInscritos;
    private Entrada entrada;

}
