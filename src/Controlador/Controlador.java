package Controlador;

import Modelo.Entradas.*;
import Modelo.Evento.Evento;
import Modelo.Evento.GestionEvento;
import Modelo.Usuario.*;
import Vista.*;
import com.sun.source.tree.BreakTree;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Modelo.Entradas.Entrada.entradas;
import static Modelo.Evento.Evento.*;
import static Modelo.Usuario.GestionUsuario.posArrayUsuarioActual;
import static Vista.Vista.*;

public class Controlador{
    static Scanner s = new Scanner(System.in);


    public static void Bienvenida(){
        int opcion;
        do {
            Vista.muestraMensaje(menuGeneral());
            opcion = s.nextInt();
            switch (opcion){
                case 1 -> iniciaSesion();
                case 2 -> registro();
                case 3 -> Vista.muestraMensaje("Abandonando el programa...");
                default -> Vista.muestraMensaje("Por favor, introduce alguna de las opciones que se muestran\n");
            }
        } while (opcion != 3);
    }

    public static void menuAdministrador(){
        Vista.muestraMensaje(Vista.menuAsistente());
        switch (s.nextInt()){
            case 1 -> // Panel de control (Para bloquear y desbloquear usuarios
            case 2 -> GestionEvento.muestraEventos();
            case 3 -> // Cartera digital
            case 4 -> // Configuracion
            case 5 -> cerrarSesion();
        }
    }


    public static void menuOrganizador(){
        Vista.muestraMensaje(Vista.menuOrganizador());
        switch (s.nextInt()){
            case 1 -> // Eventos creados por el organizador
            case 2 -> // Cartera del Organizador
            case 3 -> // Configuracion
            case 4 -> cerrarSesion();
        }
    }



    public static void menuAsistente(){
        Vista.muestraMensaje(Vista.menuAdministrador());
        switch (s.nextInt()){
            case 1 -> //Eventos inscritos por el usuario
            case 2 -> GestionEvento.muestraEventos();
            case 3 -> // Cartera Digital
            case 4 -> // Invita a un amigo
            case 5 -> //Configuracion
            case 6 -> cerrarSesion();
        }
    }

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

    public static int creaEntrada(int idEvento){
        Vista.muestraMensaje(Vista.creaEntradaEvento(idEvento));
        int opcion = s.nextInt();

        do {
            switch (opcion){
                case 1:
                    Vista.muestraMensaje("-- Definición de la entrada General --\n");
                    recogeDatosEntrada(idEvento, TipoEntrada.GENERAL);
                break;
                case 2:
                    Vista.muestraMensaje("-- Definición de la entrada Premium --\n");
                    recogeDatosEntrada(idEvento, TipoEntrada.PREMIUM);
                    break;
                case 3:
                    Vista.muestraMensaje("-- Definición de la entrada VIP --\n");
                    recogeDatosEntrada(idEvento, TipoEntrada.VIP);
                    break;
            }
            opcion++;
        } while (opcion==4);
        return s.nextInt();
    }


    public static void recogeDatosEntrada(int idEvento, TipoEntrada tipo){
        Vista.muestraMensaje("Introduce el precio de la entrada: ");
        int precio = s.nextInt();
        Vista.muestraMensaje("Introduce la descripción de la entrada: ");
        String descipcion = s.nextLine();
        Vista.muestraMensaje("Introduce la cantidad de entradas disponibles: ");
        int stock = s.nextInt();
        Entrada.creaEntrada(new Entrada(tipo, precio, descipcion, stock, idEvento));
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
        } else Vista.muestraMensaje("Ha ocurrido un error. Revise el ID introducido\n");
    }

    public static void eliminaEvento(int idEvento){
        if (buscaPosicionPorID(idEvento) != -1){
            Evento.eliminaEvento(idEvento);
            Vista.muestraMensaje("Evento eliminado con éxito\n");
        } else Vista.muestraMensaje("Ha ocurrido un error al intentar eliminar el evento\n");
    }


//    public static int seleccionEventoPorNombre(){
//       for (int i = 0; i < eventoCreado.length; i++) {
//            if (eventoCreado[i]) {
//                System.out.println(idEvento[i] + ". " + nombreEvento[i]);
//            }
//       }
//
//
//        int seleccionUsuario = s.nextInt();
//
//        for (int i = 0; i < eventoCreado.length; i++) if (seleccionUsuario == idEvento[i]) return i;
//        System.out.println("El ID introducido no existe");
//        return -1;
//    }



    public static void iniciaSesion(){
        boolean datosCorrectos;
        muestraMensaje("**** INICIO DE SESIÓN ****\n");
        do {
            muestraMensaje("- Introduce el correo: ");
            String correo = s.nextLine();
            muestraMensaje("Introduce la contraseña: ");
            String contrasena = s.nextLine();
            datosCorrectos = GestionUsuario.iniciarSesion(correo, contrasena);
            if (!datosCorrectos) Vista.muestraMensaje("Alguno de los campos introducidos es erroneo\n");
        } while (!datosCorrectos);
        if (GestionUsuario.usuarios[posArrayUsuarioActual] instanceof Administrador){
            menuAdministrador();
        } else if (GestionUsuario.usuarios[posArrayUsuarioActual] instanceof Organizador) {
            menuOrganizador();
        } else {
            menuAsistente();
        }
    }



    public static void registro(){
        String correo;
        Vista.muestraMensaje(Vista.registro());
        int tipoUsuario = s.nextInt();
        if (tipoUsuario < 1 || tipoUsuario > 4){
            Vista.muestraMensaje("Introduzca alguna de las opciones\n");
        } else if (tipoUsuario == 4){
            Vista.muestraMensaje("Saliendo...");
        } else{
            do {
                Vista.muestraMensaje("Introduzca su correo: ");
                correo = s.nextLine();
                if (GestionUsuario.compruebaCorreo(correo)) Vista.muestraMensaje("El correo introducido ya existe\n");
            } while (GestionUsuario.compruebaCorreo(correo));
            Vista.muestraMensaje("Introduce la contraseña: ");
            String contrasena = s.nextLine();
            Vista.muestraMensaje("Introduzca su nombre: ");
            String nombre = s.nextLine();
             switch (tipoUsuario){
                case 1 -> Administrador.registraAdministrador(new Administrador(nombre, correo, contrasena));
                case 2 -> Organizador.registraOrganizador(new Organizador(nombre, correo, contrasena));
                case 3 -> Asistente.registraAsistente(new Asistente(nombre, correo, contrasena));
            }
        }


    }

    public static void cambiaContrasena(){


    }


    public static void cerrarSesion(){
        posArrayUsuarioActual = -1;
        Bienvenida();
    }








}