package Controlador;

import Modelo.Evento;
import Vista.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Modelo.Evento.buscaEventoPorID;
import static Vista.Vista.muestraCategoria;

public class Controlador {

    public static Evento creaEvento(){
        Scanner s = new Scanner(System.in);
        Vista.muestraMensaje("Introduce el nombre del evento: ");
        String nombre = s.nextLine();
        Vista.muestraMensaje("Escribe la descripción del evento: ");
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
        Vista.muestraMensaje("Introduzca la fecha del evento: ");
        String fechaStr = s.nextLine();
        DateTimeFormatter formatof = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaStr, formatof);
        Vista.muestraMensaje("Introduce la hora del evento: ");
        String horaStr = s.nextLine();
        DateTimeFormatter formatoh = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora = LocalTime.parse(horaStr, formatoh);
        Vista.muestraMensaje("Introduce el aforo máximo permitido del evento: ");
        int aforo = s.nextInt();
        return new Evento(nombre, descripcion, categoria, fecha, hora, aforo);
    }

    public void modificaEvento(int idEvento){
        Evento evento = buscaEventoPorID(idEvento);
        if (evento!=null){
            Scanner s = new Scanner(System.in);
            Vista.muestraMensaje("Introduce el nombre del evento: ");
            String nombre = s.nextLine();
            Vista.muestraMensaje("Escribe la descripción del evento: ");
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
            Vista.muestraMensaje("Introduzca la fecha del evento: ");
            String fechaStr = s.nextLine();
            DateTimeFormatter formatof = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fechaStr, formatof);
            Vista.muestraMensaje("Introduce la hora del evento: ");
            String horaStr = s.nextLine();
            DateTimeFormatter formatoh = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime hora = LocalTime.parse(horaStr, formatoh);
            Vista.muestraMensaje("Introduce el aforo máximo permitido del evento: ");
            int aforo = s.nextInt();
            evento.modificaEvento(nombre, descripcion, categoria, fecha, hora, aforo);
        } else Vista.muestraMensaje("Ha ocurrido un error. revise el ID introducido");

    }


}
