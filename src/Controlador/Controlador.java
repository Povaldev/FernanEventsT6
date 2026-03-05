package Controlador;

import Modelo.Evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Vista.Vista.muestraCategoria;

public class Controlador {

    public static Evento creaEvento(){
        Scanner s = new Scanner(System.in);
        Vista.Vista.muestraMensaje("Introduce el nombre del evento: ");
        String nombre = s.nextLine();
        Vista.Vista.muestraMensaje("Escribe la descripción del evento: ");
        String descripcion = s.nextLine();
        muestraCategoria();
        int opcion = Integer.parseInt(s.nextLine());
        String categoria = switch (opcion) {
            case 1 -> "Arte";
            case 2 -> "Tecnología";
            case 3 -> "Cine";
            case 4 -> "Música";
            case 5 -> "Juegos";
            case 6 -> "Comida";
            case 7 -> "Moda";
            default -> "";
        };
        Vista.Vista.muestraMensaje("Introduzca la fecha del evento: ");
        String fechaStr = s.nextLine();
        DateTimeFormatter formatof = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaStr, formatof);
        Vista.Vista.muestraMensaje("Introduce la hora del evento: ");
        String horaStr = s.nextLine();
        DateTimeFormatter formatoh = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora = LocalTime.parse(horaStr, formatoh);
        Vista.Vista.muestraMensaje("Introduce el aforo máximo permitido del evento: ");
        int aforo = s.nextInt();
        return new Evento(nombre, descripcion, categoria, fecha, hora, aforo);
    }



}
