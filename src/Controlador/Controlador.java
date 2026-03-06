package Controlador;

import Modelo.Entradas.Entrada;
import Modelo.Entradas.TipoEntrada;
import Modelo.Evento;
import Vista.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Modelo.Evento.*;
import static Vista.Vista.muestraCategoria;

public class Controlador{
    static Scanner s = new Scanner(System.in);

    public static Evento creaEvento(){
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

    public static void modificaEvento(int idEvento){
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
        } else Vista.muestraMensaje("Ha ocurrido un error. Revise el ID introducido");
    }

    public static void eliminaEvento(int idEvento){
        if (buscaPosicionPorID(idEvento) != -1){
            Evento.eliminaEvento(idEvento);
            Vista.muestraMensaje("Evento eliminado con éxito");
        } else Vista.muestraMensaje("Ha ocurrido un error al intentar eliminar el evento");
    }

    public void creaEntrada(int idEvento){
        int tipo;
        TipoEntrada tipoEntrada;
        do{
            Vista.creaEntrada(idEvento);
            tipo = s.nextInt();
            if ((tipo > 3) || (tipo < 1)) System.out.println("Debes introducir alguna de las opciones correspondientes");
        } while ((tipo > 3) || (tipo < 1));

        tipoEntrada = switch (tipo){
            case 1 -> TipoEntrada.GENERAL;
            case 2 -> TipoEntrada.PREMIUM;
            case 3 -> TipoEntrada.VIP;
            default -> null;
        };
        recogeDatosEntrada(idEvento, tipoEntrada);
    }

    public static void recogeDatosEntrada(int idEvento, TipoEntrada tipo){
        Vista.muestraMensaje("Introduce el precio de la entrada");
        int precio = s.nextInt();
        Vista.muestraMensaje("Introduce la descripción de la entrada");
        String descipcion = s.nextLine();
        Vista.muestraMensaje("Introduce la cantidad de entradas disponibles");
        int stock = s.nextInt();
        Entrada.creaEntrada(new Entrada(tipo, precio, descipcion, stock, idEvento));
    }
}






















