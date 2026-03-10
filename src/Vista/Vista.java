package Vista;

import Modelo.Evento.GestionEvento;
import Modelo.Usuario.GestionUsuario;
import Modelo.Usuario.Organizador;
import Modelo.Usuario.Usuario;

import static Modelo.Evento.GestionEvento.cantEventosCreados;
import static Modelo.Evento.GestionEvento.eventos;
import static Modelo.Usuario.GestionUsuario.posArrayUsuarioActual;
import static Modelo.Usuario.GestionUsuario.usuarios;

public class Vista {

    public static String menuGeneral(){
        String muestra = "" +
                "███████╗███████╗██████╗  ███╗   ██╗ █████╗ ███╗   ██╗\n" +
                "██╔════╝██╔════╝██╔══██╗ ████╗  ██║██╔══██╗████╗  ██║\n" +
                "█████╗  █████╗  ██████╔╝ ██╔██╗ ██║███████║██╔██╗ ██║\n" +
                "██╔══╝  ██╔══╝  ██╔══██╗ ██║╚██╗██║██╔══██║██║╚██╗██║\n" +
                "██║     ███████╗██║  ██║ ██║ ╚████║██║  ██║██║ ╚████║\n" +
                "╚═╝     ╚══════╝╚═╝  ╚═╝ ╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═══╝\n" +
                "███████╗██╗     ██╗███╗   ██╗███████╗███╗   ██╗████████╗███████╗\n" +
                "██╔════╝╚██╗   ██╔╝████╗  ██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝\n" +
                "█████╗   ╚██╗ ██╔╝ ██╔██╗ ██║█████╗  ██╔██╗ ██║   ██║   ███████╗\n" +
                "██╔══╝    ╚████╔╝  ██║╚██╗██║██╔══╝  ██║╚██╗██║   ██║   ╚════██║\n" +
                "███████╗   ╚██╔╝   ██║ ╚████║███████╗██║ ╚████║   ██║   ███████║\n" +
                "╚══════╝    ╚═╝    ╚═╝   ╚══╝╚══════╝╚═╝   ╚══╝   ╚═╝   ╚══════╝\n\n" +
                "             G E S T I Ó N   D E   E V E N T O S\n";
        muestra += "Bienvenido a FernanEvents, ¿Como deseas acceder?\n";
        muestra += "1--Iniciar Sesión\n";
        muestra += "2--Registrarse\n";
        muestra += "3--Salir\n";
        return muestra;
    }


    public static String registro(){
        String muestra = ("**** REGISTRO ****\n");
        muestra += "¿Como desea registarse?\n";
        muestra += "1. Administrador\n";
        muestra += "2. Organizador\n";
        muestra += "3. Asistente\n";
        muestra += "4. Salir\n";
        return muestra;
    }

    public static String menuAsistente(){
        String muestra = "----Bienvenido al Asistente----\n";
        muestra += "1--Mis eventos\n";
        muestra += "2--Eventos\n";
        muestra += "3--Cartera digital\n";
        muestra += "4--Invita a un amigo\n";
        muestra += "5--Configuración\n";
        muestra += "6--Cerrar sesión\n";
        return muestra;
    }

    public static String menuOrganizador(){
        String muestra = "----Bienvenido al Organizador----\n";
        muestra += "1--Mis eventos\n";
        muestra += "2--Cartera digital\n";
        muestra += "3--Configuración\n";
        muestra += "4--Cerrar sesión\n";
        return muestra;
    }

    public static String submenuEventosOrganizador(){
        Organizador organizador = (Organizador) usuarios[posArrayUsuarioActual];
        String muestra = "--- Eventos Creados ----\n";
        if (cantEventosCreados==0){
            muestra += "No hay ningún evento creado aún";
            muestra += "1. Crear Evento\n";
            muestra += "2. Salir";
        }
        else {
            for (int i = 0; i < GestionEvento.cantEventosCreados; i++) {
                muestra += organizador.eventos[i].toString();
            }
            muestra += "1. Modificar Evento\n";
            muestra += "2. Eliminar Evento";
            muestra += "3. Crear evento";
            muestra += "4. Salir";
        }
        return muestra;
    }

    public static String submenuEventosAdministrador(){

    }



    public static String menuAdministrador(){
        String muestra = "---Bienvenido al Administrador----\n";
        muestra += "1--Panel de control\n";
        muestra += "2--Eventos\n";
        muestra += "3--Cartera Digital\n";
        muestra += "4--Configuración\n";
        muestra += "5--Cerrar sesión\n";
        return muestra;
    }
    
    public static String compraEntrada(int tipoEntradas, int posicionEvento){
        String muestra = "";
        if (tipoEntradas == 1){
            muestra += eventos[posicionEvento].tipoEntradas[1].toString();
        } else if (tipoEntradas == 2) {
            muestra += eventos[posicionEvento].tipoEntradas[1].toString();
            muestra += eventos[posicionEvento].tipoEntradas[2].toString();
        } else if (tipoEntradas == 3) {
            muestra += eventos[posicionEvento].tipoEntradas[1].toString();
            muestra += eventos[posicionEvento].tipoEntradas[2].toString();
            muestra += eventos[posicionEvento].tipoEntradas[3].toString();
            
        }
        muestra += "Selecciona la entrada que desea comprar";
        return muestra;
    }



    public static String menuPanelDeControl(){
        String muestra = "----Panel de control----\n";
        muestra += "Escriba los datos del usuario al que desea bloquear/desbloquear\n";

        return muestra;
    }


    public static void muestraMensaje(String mensaje){
        System.out.print(mensaje);
    }

    public static void muestraCategoria(){
        String muestraCategoria = "-- Introduce la categoría del evento --\n";
        muestraCategoria += "1. Arte\n";
        muestraCategoria += "2. Tecnología\n";
        muestraCategoria += "3. Cine\n";
        muestraCategoria += "4. Música\n";
        muestraCategoria += "5. Juegos\n";
        muestraCategoria += "6. Comida\n";
        muestraCategoria += "7. Moda\n";
        muestraMensaje(muestraCategoria);
    }




    public static String vistaDetalladaEvento(double porcentajeOcupacion) {
        String vistaDetalladaEvento = "";
        vistaDetalladaEvento += "════════════════════\n";
        vistaDetalladaEvento += "║";
        for (int i = 0; i < (porcentajeOcupacion / 5); i++) {
            vistaDetalladaEvento += "█";
        }
        for (int i = 0; i < (100 - porcentajeOcupacion) / 5; i++) {
            vistaDetalladaEvento += " ";
        }
        vistaDetalladaEvento += "║\n";
        vistaDetalladaEvento += porcentajeOcupacion + "% de Ocupación\n";
        vistaDetalladaEvento += "════════════════════\n";
        //vistaEntradasYPrecios(idEvento);

        return vistaDetalladaEvento;
    }


//    public static void muestraNombresDeEventos(){
//        for (int i = 0; i < Evento.getCantEventosCreados(); i++) {
//            muestraMensaje();
//        }
//    }

    public static String creaEntradaEvento(){
        String muestra = "-- Selecciona las entrada/s que tendrá el evento --\n";
        muestra += "1. General\n";
        muestra += "2. General, Premium\n";
        muestra += "3. General, Premium, VIP\n";
        muestra += "4. Salir \n";
        return muestra;
    }




}
