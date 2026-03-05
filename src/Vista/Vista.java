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
        String muestraCategoria = "Introduce la categoría del evento";
        muestraCategoria += "1. Arte";
        muestraCategoria += "2. Tecnología";
        muestraCategoria += "3. Cine";
        muestraCategoria += "4. Música";
        muestraCategoria += "5. Juegos";
        muestraCategoria += "6. Comida";
        muestraCategoria += "7. Moda";
        muestraMensaje(muestraCategoria);
    }




}
