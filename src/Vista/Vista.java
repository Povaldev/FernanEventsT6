package Vista;

public class Vista {
    public static String menuAsistente(){

    }

    public static String menuOrganizador(){

    }

    public static String menuAdministrador(){

    }

    public static String vistaEvento(){

    }

    public static String vistaDetalladaEvento(){

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



}
