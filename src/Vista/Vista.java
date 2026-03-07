package Vista;

import java.util.Scanner;

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
        muestra += "Bienvenido a FernanEvents, ¿Como deseas acceder?";
        muestra += "1--Administrador";
        muestra += "2--Organizador";
        muestra += "3--Asistente";
        muestra += "4--Salir";
        return muestra;
    }


    public static String menuAsistente(){
        String muestra = "Bienvenido al Administrador";
        muestra += "1--Panel de control";
        muestra += "2--Eventos";
        muestra += "3--Cartera Digital";
        muestra += "4--Configuración";
        muestra += "5--Cerrar sesión";
        return muestra;
    }

    public static String menuOrganizador(){
        String muestra = "Bienvenido al Organizador";
        muestra += "1--Mis eventos";
        muestra += "2--Cartera digital";
        muestra += "3__Configuración";
        muestra += "4--Cerrar sesión";
        return muestra;
    }

    public static String menuAdministrador(){
        String muestra = "Bienvenido al Asistente ";
        muestra += "1--Mis eventos";
        muestra += "2--Eventos";
        muestra += "3--Cartera digital";
        muestra += "4--Invita a un amigo";
        muestra += "5__Configuración";
        muestra += "6--Cerrar sesión";
        return muestra;
    }


    public static String inscripcionEventoPago(){

    }

    public static void muestraMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public static void muestraCategoria(){
        String muestraCategoria = "Introduce la categoría del evento\n";
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

    public static void creaEntrada(int idEvento){
        Vista.muestraMensaje("- Selecciona las entradas que tendrá el evento");
        System.out.println("1. General");
        System.out.println("2. General y Premium");
        System.out.println("3. General, Premium y VIP");
    }



}
