package Controlador;

import Modelo.Entradas.*;
import Modelo.Evento;
import Modelo.Usuario.Administrador;
import Modelo.Usuario.GestionUsuario;
import Modelo.Usuario.Organizador;
import Vista.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Modelo.Evento.*;
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
        Vista.muestraMensaje(Vista.menuAdministrador());
        switch (s.nextInt()){

        }
    }


    public static void menuOrganizador(){
        int opcion;
        Vista.menuOrganizador();
    }



    public static void menuAsistente(){

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
        Vista.muestraMensaje("Introduce el precio de la entrada: ");
        int precio = s.nextInt();
        Vista.muestraMensaje("Introduce la descripción de la entrada: ");
        String descipcion = s.nextLine();
        Vista.muestraMensaje("Introduce la cantidad de entradas disponibles: ");
        int stock = s.nextInt();
        Entrada.creaEntrada(new Entrada(tipo, precio, descipcion, stock, idEvento));
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
        int tipoUsuario;
        String correo;
        Vista.muestraMensaje(Vista.registro());
        switch (s.nextInt()){
            case 1 -> tipoUsuario = 1;
            case 2 -> tipoUsuario = 2;
            case 3 -> tipoUsuario = 3;
            case 4 -> Vista.muestraMensaje("Saliendo...");
            default -> Vista.muestraMensaje("Introduzca alguna de las opciones");
        }
        do{
            Vista.muestraMensaje("Introduzca su correo: ");
            correo = s.nextLine();
            if (GestionUsuario.compruebaCorreo(correo)) Vista.muestraMensaje("El correo introducido ya existe");
        } while (GestionUsuario.compruebaCorreo(correo));


        Vista.muestraMensaje("Introduce la contraseña: ");
    }

    public static void cambiaContrasena(){


    }








}