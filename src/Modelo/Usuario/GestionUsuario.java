package Modelo.Usuario;

public class GestionUsuario {
    public static Usuario[] usuarios = new Usuario[10];
    public static int cantUsuariosRegistrados;
    public static int posArrayUsuarioActual;

    public static boolean iniciarSesion(String correo, String contrasena){
        for (int i = 0; i < cantUsuariosRegistrados; i++) {
            if (usuarios[i].getCorreo().equals(correo)){
                System.out.printf("aaaaa");
                if (usuarios[i].getContrasena().equals(contrasena)){
                    System.out.printf("bbbbb");
                    posArrayUsuarioActual = i;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean compruebaCorreo(String correo){
        for (int i = 0; i < cantUsuariosRegistrados; i++) {
            if (usuarios[i].getCorreo().equals(correo)) return true;
        }
        return false;
    }

}
