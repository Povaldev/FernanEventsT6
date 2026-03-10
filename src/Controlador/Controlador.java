package Controlador;

import Modelo.Entradas.*;
import Modelo.Evento.Evento;
import Modelo.Evento.GestionEvento;
import Modelo.Usuario.*;
import Vista.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import static Modelo.Evento.Evento.*;
import static Modelo.Evento.GestionEvento.cantEventosCreados;
import static Modelo.Evento.GestionEvento.eventos;
import static Modelo.Usuario.GestionUsuario.posArrayUsuarioActual;
import static Modelo.Usuario.GestionUsuario.usuarios;
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
            case 1 -> bloquearUsuarios();
            case 2 -> submenuEventos();
//            case 3 -> // Cartera digital
//            case 4 -> // Configuracion
            case 5 -> cerrarSesion();
        }
    }


    public static void menuOrganizador(){
        int opcion;
        if (Organizador.bloquear()){
            Vista.muestraMensaje("El organizador esta bloqueado, pida a un administrador que se desbloque");
        }else {
            do {
                Vista.muestraMensaje(Vista.menuOrganizador());
                opcion = s.nextInt();
                switch (opcion){
                    case 1 -> submenuEventos();
                    // case 2 -> // Cartera del Organizador
                    // case 3 -> // Configuracion
                    case 4 -> cerrarSesion();
                }
            } while (opcion==4);


        }

    }

    public static void submenuEventos(){
        Vista.muestraMensaje(Vista.submenuEventosOrganizador());
        int opcion = s.nextInt();
        if (cantEventosCreados==0){
            switch (opcion){
                case 1 -> creaEvento();
                case 2 -> Vista.muestraMensaje("Saliendo...");
                default -> Vista.muestraMensaje("Por favor, introduzca la opción correspondiente");
            }
        }
        switch (opcion){
            case 1:
                Vista.muestraMensaje("Introduce el ID del evento que desea modificar: ");
                modificaEvento(s.nextInt());
                break;
            case 2:
                Vista.muestraMensaje("Introduce el ID del evento que desea eliminar: ");
                eliminaEvento(s.nextInt());
                break;
            case 3:
                creaEvento();
                break;
            case 4:
                Vista.muestraMensaje("Saliendo...\n");
                break;
            default:
                Vista.muestraMensaje("Introduce alguna de las opciones correspondientes");
                break;
        }
    }



    public static void menuAsistente(){
        Vista.muestraMensaje(Vista.menuAsistente());
        switch (s.nextInt()){
//            case 1 -> //Eventos inscritos por el usuario
            case 2 -> GestionEvento.muestraEventos();
//            case 3 -> // Cartera Digital
//            case 4 -> // Invita a un amigo
//            case 5 -> //Configuracion
            case 6 -> cerrarSesion();
        }
    }

    public static void creaEvento(){
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
        GestionEvento.creaEvento(new Evento(nombre, descripcion, categoria, fecha, hora, aforo));
    }


    public static void creaEntrada(int idEvento){
        Vista.muestraMensaje(Vista.creaEntradaEvento());
        int correspondencia = s.nextInt();
        if (correspondencia>1 && correspondencia<5){
            if (correspondencia == 4){
                Vista.muestraMensaje("Saliendo...");
            } else {
                for (int i = 1; i <= correspondencia; i++) {
                    switch (i){
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
                }
                eventos[GestionEvento.devuelvePosicionPorID(idEvento)].setCantEntradas(correspondencia);
            }
        } else Vista.muestraMensaje("No ha introducido ninguna opción de la pantalla");
    }


    public static void recogeDatosEntrada(int idEvento, TipoEntrada tipo){
        Vista.muestraMensaje("Introduce el precio de la entrada: ");
        int precio = s.nextInt();
        Vista.muestraMensaje("Introduce la descripción de la entrada: ");
        String descipcion = s.nextLine();
        Vista.muestraMensaje("Introduce la cantidad de entradas disponibles: ");
        int stock = s.nextInt();
        enlazaEntradaAEvento(new Entrada(tipo, precio, descipcion, stock, idEvento), idEvento);
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
            GestionEvento.eliminaEvento(idEvento);
            Vista.muestraMensaje("Evento eliminado con éxito\n");
        } else Vista.muestraMensaje("Ha ocurrido un error al intentar eliminar el evento\n");
    }


    public static void iniciaSesion(){
        boolean datosCorrectos;
        muestraMensaje("**** INICIO DE SESIÓN ****\n");
        do {
            muestraMensaje("- Introduce el correo: ");
            String correo = s.next();
            muestraMensaje("Introduce la contraseña: ");
            String contrasena = s.next();
            datosCorrectos = GestionUsuario.iniciarSesion(correo, contrasena);
            if (!datosCorrectos) Vista.muestraMensaje("Alguno de los campos introducidos es erroneo\n");
        } while (!datosCorrectos);
        if (GestionUsuario.usuarios[posArrayUsuarioActual] instanceof Administrador){
            menuAdministrador();
        } else if (GestionUsuario.usuarios[posArrayUsuarioActual] instanceof Organizador) {
            menuOrganizador();
        } else if (GestionUsuario.usuarios[posArrayUsuarioActual] instanceof Asistente){
            menuAsistente();
        }
    }


    public static void registro(){
        String correo;
        Vista.muestraMensaje(Vista.registro());
        int tipoUsuario = Integer.parseInt(s.next());
        if (tipoUsuario < 1 || tipoUsuario > 4){
            Vista.muestraMensaje("Introduzca alguna de las opciones\n");
        } else if (tipoUsuario == 4){
            Vista.muestraMensaje("Saliendo...\n");
        } else{

            do {
                Vista.muestraMensaje("Introduzca su correo: ");
                correo = s.next();
                if (GestionUsuario.compruebaCorreo(correo)) Vista.muestraMensaje("El correo introducido ya existe\n");
            } while (GestionUsuario.compruebaCorreo(correo));
            Vista.muestraMensaje("Introduce la contraseña: ");
            String contrasena = s.next();
            Vista.muestraMensaje("Introduzca su nombre: ");
            String nombre = s.next();
             switch (tipoUsuario){
                case 1 -> Administrador.registraAdministrador(new Administrador(nombre, correo, contrasena));
                case 2 -> Organizador.registraOrganizador(new Organizador(nombre, correo, contrasena));
                case 3 -> Asistente.registraAsistente(new Asistente(nombre, correo, contrasena));
            }
        }
    }


    public static void menuEventosAsistente(){
        GestionEvento.muestraEventos();
        Vista.muestraMensaje("- ¿Desea comprar una entrada para un evento? (s/n)");
        if (s.next().equals("s")){
            // TODO controlar que no hayan 2 nombres iguales entre eventos al crear un evento
            Vista.muestraMensaje("Introduce el nomrbe del evento al que se quiere inscribir: ");
            String nombreEvento = s.next();
            int eventoID = GestionEvento.devuelveIDPorNombre(nombreEvento);
            if (eventoID == -1) Vista.muestraMensaje("El nombre que ha introducido no corresponde a ningún evento");
            else compraEntrada(eventoID);
        }
    }

    /// Función en el que el usuario visualiza las entradas del evento que ha seleccionado anteriormente y recoge el tipo de entrada que desea comprar
    /// Posteriormente se llama al metodo especifico del Asistente "compraEntrada". Para ello se hace casting de la posicion de usuario actual del array general de usuarios de la clase GestionUsuario
    public static void compraEntrada(int eventoID){
        int posicionEvento = GestionEvento.devuelvePosicionPorID(eventoID);
        Vista.muestraMensaje(Vista.compraEntrada(eventos[posicionEvento].getCantEntradas(), posicionEvento));
        // Entrada que el user desea comprar
        String tipoEntradaStr = s.next().toLowerCase();
        int tipoEntrada = switch (tipoEntradaStr){
            case "general" -> 0;
            case "premium" -> 1;
            case "vip" -> 2;
            default -> -1;
        };
        if (tipoEntrada == -1) Vista.muestraMensaje("Por favor, introduce el tipo correspondiente");
        else {
            Asistente asistente = (Asistente) usuarios[posArrayUsuarioActual];
            asistente.compraEntrada(eventoID, tipoEntrada);
        }
    }



    public static void cambiaContrasena(){


    }


    public static void cerrarSesion(){
        posArrayUsuarioActual = -1;
        Bienvenida();
    }

    public static void bloquearUsuarios(){

        Vista.menuPanelDeControl();

        Vista.muestraMensaje("Introduzca el usuario");
        String usuario=s.next();
        Vista.muestraMensaje("Introduzca la contraseña");
        String contrasena=s.next();

        if (GestionUsuario.usuarios[posArrayUsuarioActual] instanceof Administrador){
            Vista.muestraMensaje("El admin no se puede bloquear");
        } else if (GestionUsuario.usuarios[posArrayUsuarioActual] instanceof Organizador) {
            Organizador.setBloqueo(true);
        } else {
            //menuAsistente();
        }


    }






}