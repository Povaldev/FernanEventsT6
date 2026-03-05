package Modelo;

import Modelo.Entradas.Entrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Vista.Vista.*;

public class Evento {
    public static Evento[] eventos;
    private String nombre, descripcion, categoria;
    private LocalDate fecha, hora;
    private int aforo, numInscritos;
    private Entrada entrada;

    public void creaEvento(){
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce el nombre del evento: ");
        nombre = s.nextLine();
        System.out.print("Escribe la descripción del evento: ");
        descripcion = s.nextLine();
        muestraCategoria();
        int opcion = Integer.parseInt(s.nextLine());
        categoria = switch (opcion) {
            case 1 -> "Arte";
            case 2 -> "Tecnología";
            case 3 -> "Cine";
            case 4 -> "Música";
            case 5 -> "Juegos";
            case 6 -> "Comida";
            case 7 -> "Moda";
            default -> "";
        };
        System.out.print("Introduzca la fecha del evento: ");
        String fechaStr = s.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaStr, formato);
        System.out.print("Introduce la hora del evento: ");
        hora = s.next();
        System.out.print("Introduce el aforo máximo permitido del evento: ");
        aforo = s.nextInt();
        tipoEntradas(posicionArrayEvento);
        eventoCreado[posicionArrayEvento] = true;
        idEvento[posicionArrayEvento] = generaIDsEventos;
        cantEventosCreados++;
    }
}
